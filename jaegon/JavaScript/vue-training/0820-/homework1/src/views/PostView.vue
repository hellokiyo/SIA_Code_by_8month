<template>

  <div class="px-4 py-2" style="background-color: #eeeeee; margin-bottom: 60px">
    <div>

      <!--게시물 1번 -->
      <div v-for="(item,index) in posts" :key="item.id" class="card postcard">

        <div class="card-body m-0 p-0">
          <img :src="item.thumbnail">

          <div class="p-4">
            <h5 class="fw-bold fs-3">{{ item.title }}</h5>
            <span class="text-muted">{{ item.contents }}</span>
          </div>
        </div>

        <div class="card-footer d-flex justify-content-between align-items-center py-5">
            <span class="d-flex align-items-center text-gray-600 fs-5">
              <i class="ki-duotone ki-like text-primary fs-2x me-2">
               <span class="path1"></span>
               <span class="path2"></span>
              </i>
              <span>{{ item.likes }}</span>
            </span>

          <span class="d-flex align-items-center text-gray-600 fs-5">
             <i class="ki-duotone ki-message-text-2 text-primary fs-2x me-2">
             <span class="path1"></span>
             <span class="path2"></span>
             <span class="path3"></span>
            </i>
              <span>1</span>
            </span>

          <span class="badge badge-light-primary px-5 py-2">{{ item.category }}</span>
          <span class="text-muted">{{ item.createDate }}</span>


        </div>

      </div>
      <div class="mb-10">
        <button class="btn btn-light-primary w-100 mt-3 fs-1" @click ="goToPostWrite()">
          <i class="ki-duotone ki-plus fs-2x me-2"></i>
          <span>새 게시물 작성</span>
        </button>

      </div>

    </div>

  </div>
</template>

<script setup>
import { ref, onMounted} from "vue";

//라우터
import { useRouter } from "vue-router";
const router =useRouter();


//스토어 불러오기
// 1. storeToRefs 불러오기
import { storeToRefs } from "pinia";

// 2. 내 스토어(app.js) 불러오기
import { useAppStore } from "../stores/app.js";

// 3. 스토어 실행 (실제로 가져오기)
const appStore = useAppStore();

// 4. 반응형으로 가져오기
const { title } = storeToRefs(appStore);

//게시글 리스트를 JSON파일로 만들어서 받아오기
import postList from "@/data/postList.json";
//게시글 목록을 위한 변수
const posts = ref(postList)

onMounted(() => {
  console.log(`PostView::onMounted 호출됨`);

  title.value ='게시물';
})

//새 게시글 작성 화면으로
function goToPostWrite() {
  router.push('/post-write');
}

</script>

<style scoped>
 .postcard {
   border: none;
   border-radius: 0.75rem;
   box-shadow: 0 2px 8px rgba(0, 0, 0, 0.005);
   margin-top: 1rem;
   margin-bottom: 1rem;
   transition: transfrom 0.2s;
 }
 .postcard:hover {
   transform: translateY(-5px);
 }
 .postcard img {
   border-radius: 0.5rem;
   object-fit: cover;
   height: 180px;
   width: 100%;
 }



</style>