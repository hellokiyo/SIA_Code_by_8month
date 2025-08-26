<template>
  <div>
    <!-- ===== 홈화면 ===== -->
    <div>
      <h1>홈화면</h1>
    </div>

    <!-- ===== 이름 표시 / 입력 영역 ===== -->
    <div>
      <div v-if="nameVisible">
        <label>이름 : </label>
        <span>{{name}}</span>
      </div>

      <div v-else>
        <label>나이 : </label>
        <span>21</span>
      </div>

      <div>
        <label>이름 입력 : </label>
        <input type="text" v-model="nameInput">
      </div>

      <div>
        <button @click="show()">확인</button>
      </div>
    </div>

    <!-- ===== 동물 목록 영역 ===== -->
    <div>
      <div style="margin-top: 2em; margin-bottom: 2em; ">
        <span>동물들</span>
        <button @click="addAnimal()">추가</button>

        <button class="btn btn-sm btn-primary ms-4" @click="showDialog()">대화상자 띄우기</button>
      </div>

      <!-- 동물 카드 반복 -->
      <div v-for="(item, index) in animals" :key="item.id"
           :class="(item.type === 'dog') ? 'dog-style' : 'cat-style'"
           style=" border: 1px solid red; margin-bottom: 10px">

        <div style="margin-bottom: 1em;">
          <label>구분 : </label>
          <span>{{(item.type === 'dog') ? '강아지' : (item.type === 'cat') ? '고양이' : '모름'}}</span>

          <button @click="modifyAnimal(index)">수정</button>
          <button @click="removeAnimal(index)">삭제</button>
        </div>

        <div style="margin-bottom: 1em;" >
          <label>이름 : </label>
          <span>{{ item.name }}</span>
        </div>

        <div style="margin-bottom: 1em;" >
          <label>나이 : </label>
          <span>{{ item.age }}</span>
        </div>

        <div style="margin-bottom: 1em;" >
          <label>전화번호 : </label>
          <span>{{ item.mobile }}</span>
        </div>

        <div>
          <label>이미지 : </label>
          <img :src="item.path" width="50%" />
        </div>

      </div>

      <!-- 페이지네이션 -->
      <div style="margin-top: 1em;">
        <Pagination :requestFunc="requestAnimalList" :pagination="pagination1" />
      </div>
    </div>
  </div>

  <!-- ===== 대화상자(Modal) ===== -->
  <div class="modal fade" id="myDialog">
    <!-- fade : 열리고 닫힐 때 애니메이션(페이드 인/아웃) 효과 -->
    <div class="modal-dialog modal-dialog-centered">
      <!-- modal-dialog-centered : 모달을 화면의 세로 중앙에 배치 -->
      <div class="modal-content rounded">
      <!-- modal-content : 모달의 실제 내용이 들어가는 컨테이너.  rounded : 모서리를 둥글게 처리-->
        <div class="modal-header">
          <span class="fs-1 fw-bold">파일 업로드</span>
        </div>

        <div class="modal-body p-10">
          <!-- modal-body : 모달의 본문 영역. 실제 입력 UI나 텍스트가 들어감 -->
          <div>
            <label>이름 : </label>
            <input type="text" class="form-control form-control-solid">   <!-- form-control-solid : input 스타일 -->
          </div>

          <div class="mt-4">
            <input type="file" id="uploadImage" hidden @change="getFilename($event.target.files)">
            <!-- 파일선택 자체를 hidden으로 안보이게, 이벤트발생시 files를 담은 함수 실행-->

            <!-- 이미지 프리뷰(미리보기)-->
            <label for="uploadImage" class="d-flex justify-content-center">
              <img src="/assets/media/avatars/300-20.jpg" id="preview" width="50%">
            </label>


          </div>

          <div class="mt-10">
            <button class="btn btn-primary" @click="uploadFile()">업로드</button>
            <button class="btn btn-secondary" @click="closeModal()">닫기</button>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>


<script setup>

import{ ref, onMounted } from "vue"
import { useRouter } from "vue-router";
import { storeToRefs } from "pinia";
import { useAnimalStore } from '@/stores/animal'
import axios from 'axios'
import Pagination from "@/components/Pagination.vue"
import { usePagination} from "@/util/pagination"

import { Modal } from 'bootstrap'  //부트스트랩
import { useUpload } from "@/util/upload.js" //업로드
const { upload } = useUpload()


// ===== 전역/스토어 =====
const router = useRouter()
const animalStore = useAnimalStore()
const { animals, mode, selectedIndex} = storeToRefs(animalStore)
const { makePagination } = usePagination()
const pagination1 = ref({})

// ===== 반응형 변수 =====
const name = ref("홍길동1")
const nameInput = ref('')
const nameVisible = ref(true)

    // 모달 객체 담는 상자
let myDialog;
    //선택된 파일
const selectedFile = ref('')



// ===== 라이프사이클 =====
onMounted(()=> {
  console.log(`AnimalList::onMounted 호출됨`)
  requestAnimalList(1,2)
})

// ===== API 호출 (목록) =====
async function requestAnimalList(page, perPage) {
  try{
    const response = await axios({
      method: 'post',
      baseURL: `http://localhost:8001`,
      url: '/animal/v1/list',
      data: { page, perPage },
      timeout: 5000,
      responseType: "json"
    })
    console.log(`응답 -> ${JSON.stringify(response.data)}`)
    animals.value = response.data.data.data
    pagination1.value = makePagination(response.data.data.header)
  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

// ===== 대화상자 열기 =====
function showDialog() {
  console.log(`showDialog 함수 호출됨`)
  const elem = document.querySelector('#myDialog')
  myDialog = new Modal(elem)
  myDialog.show()
}

// ===== 파일 선택 =====
async function getFilename(files) {
  selectedFile.value = files[0]
  await base64()
}
function base64() {
  return new Promise((resolve, reject) => {
    let reader = new FileReader()
    reader.onload = e => { // 화살표함수에서 파라미터 하나면 소괄호 생략
                           // 다 읽으면 e 함수 실행
      resolve(e.target.result)

      const previewImage = document.querySelector('#preview')
      previewImage.src = e.target.result
      // 결과물 업로드
    }

    reader.readAsDataURL(selectedFile.value)
  })
}

// 파일 업로드
async function uploadFile() {
  console.log(`uploadFile 함수 호출됨 -> ${selectedFile.value.name}`)

  try{
  const response = await upload(selectedFile.value, (progress) => {
    console.log(`업로드 진행률 : ${progress}`)
  })

  console.log(`업로드 응답 -> ${JSON.stringify(response)}`)
  }catch(err) {
    console.error(`업로드 중 에러 -> ${err}`)
  }

}


// ===== 이름 확인 버튼 =====
function show() {
  console.log(`show함수 호출됨`)
  name.value = nameInput.value
  nameVisible.value = false
}

// ===== 추가 버튼 =====
function addAnimal() {
  console.log(`addAnimal 함수 호출됨`)
  mode.value = 'add'
  router.replace('/animal-add', {})
}

// ===== 수정 버튼 =====
function modifyAnimal(index) {
  console.log(`modifyAnimal 함수 호출됨 -> ${index}`)
  mode.value = 'modify'
  selectedIndex.value = index
  router.replace('/animal-add', { index })
}

// ===== 삭제 버튼 =====
function removeAnimal(index) {
  console.log(`removeAnimal 함수 호출됨 -> ${index}`)
  const item = { id : animals.value[index].id }
  requestAnimalRemove(item)
}

// ===== API 호출 (삭제) =====
async function requestAnimalRemove(item) {
  try{
    const response = await axios({
      method: 'post',
      baseURL: `http://localhost:8001`,
      url: '/animal/v1/remove',
      data: item,
      timeout: 5000,
      responseType: "json"
    })
    console.log(`응답 -> ${JSON.stringify(response.data)}`)
    requestAnimalList(1,10)
  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}


  function closeModal() {
    console.log(`closeModal 함수 호출됨`)

    myDialog.hide()
  }
  </script>


<style scoped>
.dog-style {
  background-color: aqua;
}

.cat-style {
  background-color: darkcyan;
}
</style>
