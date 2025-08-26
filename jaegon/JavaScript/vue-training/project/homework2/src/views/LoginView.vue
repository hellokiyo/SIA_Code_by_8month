<template>

  <div id="background" class="bg-light-primary">
    <div class="d-flex justify-content-around">
      <h1>로그인 화면</h1>
    </div>

    <div class="d-flex justify-content-around">
      <button class="d-flex justify-content-center align-items-center h-100 btn btn-primary" @click="login()">로그인</button>
    </div>
  </div>

</template>

<script setup>

import { useRouter } from "vue-router";
const router =useRouter();


//스토어 불러오기
import {storeToRefs} from "pinia";

//가져오는건 아래 3줄로 만듦
import {useAppStore} from "@/stores/app.js";
const app = useAppStore();
const fullScreen = storeToRefs(app);


function login() {
  goToHome();
}

function goToHome() {
  //전체화면 변경하기
  fullScreen.value = false;

  router.push('/')

}



</script>


<style scoped>
#background {

}
</style>