<template>

  <div class="px-4 py-2" style=" margin-bottom: 60px">
    <div class="card ">
      <div class="card-body">

        <div class="mb-10" >
          <label class="form-label fw-bold">제목</label>
          <input type="text" class="form-control" v-model = "titleInput" placeholder="제목 입력">
        </div>

        <div class="mb-10">
          <label class="form-label fw-bold">내용</label>
          <input type="text" class="form-control" rows="3" v-model = "contentInput" placeholder="내용 입력">
        </div>

        <div class="mb-10">
          <label class="form-label fw-bold">카테고리</label>
          <input type="text" class="form-control" rows="3" v-model = "categoryInput" placeholder="카테고리 입력">
        </div>

        <div class="mb-10">
          <label class="form-label fw-bold">날짜</label>
          <input type="text" class="form-control" rows="3" v-model = "createDateInput" placeholder="날짜 입력">
        </div>

        <div class="mb-10">
          <label class="form-label fw-bold">좋아요 수</label>
          <input type="text" class="form-control" rows="3" v-model = "likeInput" placeholder="좋아요 수 입력">
        </div>

        <div class="mb-10">
          <label class="form-label fw-bold">댓글갯수</label>
          <input type="text" class="form-control" rows="3" v-model = "commentInput" placeholder="댓글갯수 입력">
        </div>

        <div class="mb-10">
          <label class="form-label fw-bold">이미지</label>
          <input type="file" class="form-control" rows="3" placeholder="이미지 입력">
        </div>

        <div>
          <label class="form-label fw-bold">이미지</label>
          <div class="image-upload-wrap">
            <p class="text-muted m-0">이미지 선택</p>
            <input type="file" class="d-none" >
          </div>
          <div class="image-preview">
            <img :src="imagePreviewUri">
          </div>
        </div>

        <div class="card-footer">
          <div class="d-flex justify-content-around">
            <button class="btn btn-light-primary w-45 px-20 py-5" @click="save()">
              <span class="fs-3 fw-bold">저장</span>
            </button>

            <button class="btn btn-light-secondary w-45 px-20 py-5" @click="goToPost()">
              <span class="fs-3 fw-bold">취소</span>
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
const titleInput = ref("");
const contentInput = ref("");
const categoryInput = ref("");
const createDateInput = ref("");
const likeInput = ref("");
const commentInput = ref("");
const thumbnailInput = ref(""); // 썸네일 입력 필드용 변수

// 컴포넌트가 마운트(화면에 나타남)된 후 실행되는 훅입니다.
onMounted(() => {
  console.log(`PostWriteView::onMounted 호출됨`);

  // 페이지 제목을 '새 게시물 작성'으로 설정합니다.
  title.value ='새 게시물 작성';
})

// '저장' 버튼 클릭 시 호출되는 함수
function save() {

  console.log(`save 함수 호출됨`)

  // 각 입력 필드의 현재 값을 변수에 할당합니다.
  const title = titleInput.value
  const contents = contentInput.value
  const category = categoryInput.value
  const createDate = createDateInput.value
  const likes = likeInput.value
  const comments = commentInput.value
  const thumbnail = thumbnailInput.value

  // 입력된 값들을 하나의 객체로 묶습니다.
  const item = {
    title: title,
    contents: contents,
    category: category,
    createDate: createDate,
    likes: likes,
    comments: comments,
    thumbnail: thumbnail
  }

  // 게시물 추가 요청 함수를 호출하며 item 객체를 전달합니다.
  requestPostAdd(item)
}

// API를 통해 게시물을 추가하는 비동기 함수
async function requestPostAdd(item) {

  console.log(`requestPostAdd 함수 호출됨`);

  try{
    // axios를 사용하여 POST 요청을 보냅니다.
    const response = await axios({
      method: 'post',
      baseURL: `http://localhost:8001`,
      url: '/post/v1/add',
      data: item,
      timeout: 5000,
      responseType: "json"
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

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
  // '/document' 경로로 페이지를 이동시킵니다.
  router.push('/document');

}
</script>

<style scoped>
/* 이 컴포넌트에만 적용되는 스타일 */
</style>