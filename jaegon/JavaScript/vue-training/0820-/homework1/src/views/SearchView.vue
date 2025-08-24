<template>

  <div class="d-flex justify-content-center align-items-center h-100 bg-light-primary">
    <h1>찾기 화면</h1>\
  </div>

  <div class="d-flex justify-content-around py-2">
    <button class="d-flex justify-content-center align-items-center h-100 btn btn-primary" @click="login()">로그인</button>
  </div>

  <header class="d-flex align-items-center p-2 border-bottom">
    <div class="fw-bold">Logo</div>
    <nav class="ms-auto d-flex gap-2">
      <a>Home</a><a>About</a><a>Contact</a>
    </nav>
  </header>


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
  console.log(`HomeView::onMounted 호출됨`);

  title.value ='검색';
})


function login() {
  goToHome();
}

function goToHome() {
  router.push('/')
}
</script>

<style scoped>

</style>