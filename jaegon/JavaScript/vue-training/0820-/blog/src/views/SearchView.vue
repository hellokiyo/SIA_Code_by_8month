<template>

  <div class="d-flex justify-content-center align-items-center h-100 bg-light-primary">
    <h1>찾기 화면</h1>
  </div>

</template>

<script setup>

import { ref, onMounted} from "vue";

//스토어 불러오기
import {storeToRefs} from "pinia";

//가져오는건 아래 3줄로 만듦
import {useAppStore} from "@/stores/app.js";
const appStore = useAppStore();
const {title} = storeToRefs(appStore);



onMounted(() => {
  console.log(`HomeView::onMounted 호출됨`);

  title.value ='검색';
})
</script>

<style scoped>

</style>