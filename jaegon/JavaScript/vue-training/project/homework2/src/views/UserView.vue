<template>

  <div class="d-flex justify-content-center align-items-center h-100 bg-light-primary p-5"  style="border-radius: 8px">

    <div class="card-body px-4 py-2">

      <div class="card justify-content-between">

        <div class="bg-gray-500 align-items-center border-primary p-2">

          <div class="row align-items-top ">
            <div class="col-6">
              <img src="@/assets/images/cat_run.png" class="p-5">
            </div>

            <div class="col-6 pt-6">
              <span class="fs-2hx">박정훈 회원님</span><br>
              <span>환영합니다</span>
            </div>
          </div>

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
          <div>
            <i class="ki-duotone ki-teacher">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </div>
          <button class="bg-light-primary border" @click="goToHome()">매칭한 멘토</button>
        </div>


        <div class="d-flex justify-content-around mb-3">
          <div>
            <i class="ki-duotone ki-address-book">
              <span class="path1"></span>
              <span class="path2"></span>
              <span class="path3"></span>
            </i>
          </div>
          <button class="bg-light-primary border">고객센터</button>
        </div>

        <div class="d-flex justify-content-around mb-3">
          <div>
            <i class="ki-duotone ki-exit-right">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </div>
          <button class="bg-light-primary border">로그아웃</button>
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
import { useAppStore } from "@/stores/app.js";
const appStore = useAppStore();
const {title} = storeToRefs(appStore);

onMounted(() => {
  console.log(`UserView::onMounted 호출됨`);

  title.value ='마이페이지';
})

// 메인 페이지 이동
function goToHome() {
  router.push('/')
}
</script>

<style scoped>

</style>