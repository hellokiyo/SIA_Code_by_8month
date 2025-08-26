<template>

  <VideoUpload />

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