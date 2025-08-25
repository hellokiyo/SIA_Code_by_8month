<template>

  <!-- 페이지 전체 컨테이너 -->
  <div class="px-4 py-2" style="background-color: #eeeeee; margin-bottom: 60px">
    <div>

      <!-- 게시물 카드 반복 렌더링 -->
      <div v-for="(item,index) in posts" :key="item.id" class="card postcard">

        <!-- 카드 본문 -->
        <div class="card-body m-0 p-0">
          <!-- 게시물 썸네일 -->
          <img :src="item.thumbnail">

          <div class="p-4">
            <!-- 게시물 제목 -->
            <h5 class="fw-bold fs-3">{{ item.title }}</h5>
            <!-- 게시물 내용 -->
            <span class="text-muted">{{ item.contents }}</span>
          </div>
        </div>

        <!-- 카드 푸터 (좋아요, 댓글, 카테고리, 작성일) -->
        <div class="card-footer d-flex justify-content-between align-items-center py-5">

          <!-- 좋아요 영역 -->
          <span class="d-flex align-items-center text-gray-600 fs-5" @click="requestPostLike(item)">
            <i class="ki-duotone ki-like text-primary fs-2x me-2">
             <span class="path1"></span>
             <span class="path2"></span>
            </i>
            <span>{{ item.likes }}</span>
          </span>

          <!-- 댓글 영역 (현재는 무조건 1로 고정) -->
          <span class="d-flex align-items-center text-gray-600 fs-5">
            <i class="ki-duotone ki-message-text-2 text-primary fs-2x me-2">
             <span class="path1"></span>
             <span class="path2"></span>
             <span class="path3"></span>
            </i>
            <span>1</span>
          </span>

          <!-- 카테고리 표시 -->
          <span class="badge badge-light-primary px-5 py-2">{{ item.category }}</span>

          <!-- 작성일 표시 -->
          <span class="text-muted">{{ item.createDate }}</span>

        </div>

      </div>

      <!-- 새 게시물 작성 버튼 -->
      <div class="mb-10">
        <button class="btn btn-light-primary w-100 mt-3 fs-1" @click ="goToPostWrite()">
          <i class="ki-duotone ki-plus fs-2x me-2"></i>
          <span>새 게시물 작성</span>
        </button>
      </div>

      <!-- 페이지네이션 컴포넌트 -->
      <div style="margin-top: 1em;">
        <Pagination :requestFunc="requestAnimalList" :pagination="pagination1" />
      </div>

    </div>
  </div>
</template>

<script setup>
import { ref, onMounted} from "vue";

// 라우터 객체 불러오기
import { useRouter } from "vue-router";
const router = useRouter();

// ========================= Pinia 스토어 설정 =========================

// 1. storeToRefs 불러오기
import { storeToRefs } from "pinia";

// 2. 내 스토어(app.js) 불러오기
import { useAppStore } from "../stores/app.js";

// 3. 스토어 실행 (인스턴스 생성)
const appStore = useAppStore();

// 4. storeToRefs로 반응형 데이터 가져오기
const { title } = storeToRefs(appStore);

// ========================= 게시물 데이터 설정 =========================
// 게시글 목록을 ref로 관리
const posts = ref([])

// ========================= 페이지네이션 설정 =========================
import Pagination from "@/components/Pagination.vue"   // Pagination 컴포넌트 불러오기
import { usePagination } from "@/util/pagination"      // usePagination 훅 가져오기
const { makePagination } = usePagination()             // makePagination 함수 꺼내기
const pagination1 = ref({})                            // 반응형 pagination 데이터

// ========================= 라이프사이클 =========================
onMounted(() => {
  console.log(`PostView::onMounted 호출됨`);

  // Pinia 스토어에 제목 설정
  title.value ='게시물';

  // (page, perPage) → 1페이지에 2개 게시물 불러오기
  requestAnimalList(1,2)
})

// ========================= 게시물 요청 함수 =========================
// 서버에서 게시물 목록을 가져오고 pagination 세팅
async function requestAnimalList(page, perPage) {
  try {
    const response = await axios({
      method: 'post',               // POST 요청
      baseURL: `http://localhost:8001`, // 서버 주소
      url: '/post/v1/list',       // API 엔드포인트
      data: {
        page : page,                // 현재 페이지 번호
        perPage : perPage           // 페이지당 게시물 수
      },
      timeout: 5000,                // 5초 동안 응답 없으면 에러
      responseType: "json"          // 응답 타입: JSON
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`) // 응답 로그

    // TODO: 여기서 서버 응답 데이터를 posts.value에 넣어야 함 (현재는 비어있음)
    posts.value = response.data.data.data

    // 응답 헤더를 기반으로 페이지네이션 생성
    pagination1.value = makePagination(response.data.data.header)

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

// ========================= 좋아요 추가 기능 함수 =========================
// 좋아요 클릭시 좋아요가 증가하는 함수
async function requestPostLike(item) {
  try {

    item.likes++;

    const response = await axios({
      method: 'post',               // POST 요청
      baseURL: `http://localhost:8001`, // 서버 주소
      url: '/post/v1/like',       // API 엔드포인트
      data: {id: item.id},
      timeout: 5000,                // 5초 동안 응답 없으면 에러
      responseType: "json"          // 응답 타입: JSON
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`) // 응답 로그

  } catch (err) {
    console.error(`에러 -> ${err}`);
    item.likes--;
  }
}

// ========================= 새 게시물 작성 이동 =========================
function goToPostWrite() {
  router.push('/post-write');   // /post-write 라우터로 이동
}

</script>

<style scoped>
/* 게시물 카드 스타일 */
.postcard {
  border: none;
  border-radius: 0.75rem;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.005);
  margin-top: 1rem;
  margin-bottom: 1rem;
  transition: transform 0.2s;
}

/* hover 시 위로 살짝 올라가게 */
.postcard:hover {
  transform: translateY(-5px);
}

/* 카드 내부 이미지 스타일 */
.postcard img {
  border-radius: 0.5rem;
  object-fit: cover;
  height: 180px;
  width: 100%;
}
</style>
