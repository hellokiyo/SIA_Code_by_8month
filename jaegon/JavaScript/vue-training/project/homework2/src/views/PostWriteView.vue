<template>

  <div class="px-4 py-2" style=" margin-bottom: 60px">
    <div class="card ">
      <div class="card-body">

        <div v-for="(item, index) in addPostInfo" :key="index">
          <div class="mb-10" >
            <label class="form-label fw-bold">{{item.name}}</label>
            <input type="text" class="form-control" v-model = "item.value" :placeholder="item.name +' 입력'">
          </div>
        </div>

        <div>
          <label class="form-label fw-bold">이미지</label>
          <div class="image-upload-wrap">
            <p class="text-muted m-0">이미지 선택</p>
            <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)">
          </div>
          <div class="image-preview">
            <!-- 이미지 프리뷰(미리보기)-->
            <label for="uploadImage" class="d-flex justify-content-center">
              <img src="@/assets/images/InputImage.png" id="preview" width="50%">
            </label>
          </div>
        </div>

        <div class="card-footer">
          <div class="d-flex justify-content-around">
            <button class="btn btn-light-primary px-20 py-5" @click="save()">
              <span class="fs-1 fw-bold">저장</span>
            </button>

            <button class="btn btn-light-secondary w-45 px-20 py-5" @click="goToPost()">
              <span class="fs-1 fw-bold">취소</span>
            </button>

          </div>
        </div>
      </div>

    </div>

  </div>
</template>

<script setup>
// Vue 3의 Composition API 함수들을 불러옵니다.
import { ref, onMounted} from "vue";

// 라우터
import { useRouter } from "vue-router";
const router =useRouter();


// Pinia 스토어 불러오기
// 1. storeToRefs: 스토어의 상태(state)를 반응형으로 유지하며 비구조화 할당(destructuring)하기 위해 사용합니다.
import { storeToRefs } from "pinia";

// 2. 내 스토어(app.js) 불러오기
import { useAppStore } from "@/stores/app.js";

// 3. 스토어 실행
const appStore = useAppStore();

// 4. 스토어의 title 상태를 반응형으로 가져옵니다.
const { title } = storeToRefs(appStore);

// ref로 각 입력 필드와 연결될 반응형 변수들을 선언합니다.
const thumbnailInput = ref(""); // 썸네일 입력 필드용 변수

// 게시글 수정 UI 반복
const addPostInfo = ref([
  {
    name : '제목',
    value: ""
  },
  {
    name : '내용',
    value: ""
  },
  {
    name : '카테고리',
    value: ""
  }
])

// 선택된 파일 저장소
const selectedFile = ref('')

import { useUpload } from "@/util/upload.js"
const { upload } = useUpload()
import { requestConfig } from "../../app.config.js"


// 컴포넌트가 마운트(화면에 나타남)된 후 실행되는 훅입니다.
onMounted(() => {
  console.log(`PostWriteView::onMounted 호출됨`);


  // 페이지 제목을 '새 게시물 작성'으로 설정합니다.
  title.value ='새 게시물 작성';
})

// ===== 파일 선택 =====
async function getFilename(files) {
  selectedFile.value = files[0]  // 첫 번째 파일만 저장
  await base64()                 // base64 변환 실행
}

// base64 변환 (미리보기용)
function base64() {
  return new Promise((resolve, reject) => {
    let reader = new FileReader()
    reader.onload = e => {
      resolve(e.target.result)

      // 미리보기 이미지 표시
      const previewImage = document.querySelector('#preview')
      previewImage.src = e.target.result
    }
    reader.readAsDataURL(selectedFile.value)
  })
}


// '저장' 버튼 클릭 시 호출되는 함수
function save() {

  console.log(`save 함수 호출됨`)

  let today =new Date();

  const item = {
    title: addPostInfo.value[0].value,
    contents: addPostInfo.value[1].value,
    category: addPostInfo.value[2].value,
    createDate: today,
    likes: 0,
    comments: 0,
    thumbnail: thumbnailInput.value
  }
  // 게시물 추가 요청 함수를 호출하며 item 객체를 전달합니다.
  requestPostAdd(item)
}

/* 가장 좋은 방법
function save() {
  console.log(`save 함수 호출됨`);

  const item = {};

  addPostInfo.value.forEach(info => {
    item[info.key] = info.value;
  });

  item.thumbnail = thumbnailInput.value;

  requestPostAdd(item);
}
*/



// API를 통해 게시물을 추가하는 비동기 함수
async function requestPostAdd(item) {

  console.log(`requestPostAdd 함수 호출됨`);

  try{

    // 1. 업로드 요청
    let response = await upload(selectedFile.value, (progress) => {
      console.log(`업로드 진행률 : ${progress}%`)
    })

    console.log(`업로드 응답 -> ${JSON.stringify(response)}`)

    // 2 업로드 완료된 이미지 경로 추가
    item.thumbnail = `${requestConfig.baseUrl}${response.data.filename}`



    // axios를 사용하여 POST 요청을 보냅니다.
    response = await axios({
      method: 'post',
      baseURL: `http://localhost:8001`,
      url: '/post/v1/add',
      data: item,
      timeout: 5000,
      responseType: "json"
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    // 4️⃣ DB 갱신 → Vue 데이터 반영
    //posts.value = response.data.data.data

    // 게시물 추가 성공 후 게시물 목록 페이지로 이동합니다.
    goToPost()

  } catch (err) {
    // 요청 실패 시 에러를 콘솔에 출력합니다.
    console.error(`에러 -> ${err}`);
  }
}


// 게시물 목록 화면으로 이동하는 함수
function goToPost() {
  console.log("goToPost 함수 호출됨");
  // '/post' 경로로 페이지를 이동시킵니다.
  router.push('/post');

}
</script>

<style scoped>
/* 이 컴포넌트에만 적용되는 스타일 */
</style>