<template>

  <div class="d-flex justify-content-center align-items-center h-100 bg-light-primary">

    <div class="card px-4 py-2">

      <div class="card-body">

        <div class="bg-gray-500 border-primary">
          <img src="@/assets/images/cat_run.png">
        </div>

        <div>
          <label class="bg-gray-100">박정훈</label>
        </div>

      <div>
      <!--
      내정보관리 테두리만들기
      v-for로 자동화
      -->
        <div class="d-flex justify-content-around mb-3">
          <div>
            <i class="ki-duotone ki-security-user fs-2x text-primary">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </div>
          <div>
            <button class="bg-gray-100 border" @click="goToHome()">내 정보 관리</button>
          </div>


        </div>

        <div class="d-flex justify-content-around mb-3">
          <button class="bg-light-primary border">
          매칭한 멘토
          </button>
        </div>


        <div class="d-flex justify-content-around mb-3">
          <button class="bg-light-primary border">
            고객센터
          </button>
        </div>

        <div class="d-flex justify-content-around mb-3">
          <button class="bg-light-primary border">
            로그아웃
          </button>
        </div>
      </div>


      </div>

    </div>
  </div>

  <div class="d-flex justify-content-around py-2">
    <button class="d-flex justify-content-center align-items-center h-100 btn btn-primary" @click="goToHome()">홈</button>
  </div>

</template>

<script setup>

import { onMounted } from "vue";
import { useRouter } from "vue-router";
const router =useRouter();

//스토어 불러오기
import {storeToRefs} from "pinia";

//가져오는건 아래 3줄로 만듦
import { useAppStore } from "../stores/app.js";
const appStore = useAppStore();
const {title} = storeToRefs(appStore);



onMounted(() => {
  console.log(`UserView::onMounted 호출됨`);

  title.value ='마이페이지';
})

function goToHome() {
  //전체화면 변경하기
  fullScreen.value = false;

  router.push('/')
}
</script>

<style scoped>

</style>