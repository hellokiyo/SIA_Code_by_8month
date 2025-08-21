<template>
  <!-- 화면 전체 레이아웃 -->
  <div class="d-flex flex-column h-100">

    <!-- 상단 헤더: fullscreen이 아닐 때만 보임 -->
    <div v-if="!fullScreen" class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">

      <!-- 좌측 햄버거 버튼 (드로어 열기용) -->
      <button class="btn btn-icon btn-light" id="kt_app_sidebar_mobile_toggle">
        <i class="ki-duotone ki-abstract-14 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

      <!-- 가운데 타이틀 (Pinia store의 title 값 표시) -->
      <span class="fs-2 fw-bold" @click="goToHome">{{ title }}</span>

      <!-- 우측 로그인 버튼 -->
      <button class="btn btn-icon btn-light" @click="goToLogin()">
        <i class="ki-duotone ki-setting-2 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

    </div>

    <!-- 메인 콘텐츠 영역 (RouterView로 페이지 전환됨) -->
    <div class="flex-grow-1 overflow-auto bg-secondary p-lg-20 h-90" style="padding-bottom: 60px;">
      <div class="d-flex flex-column flex-root app-root" id="kt_app_root">
        <RouterView />
      </div>
    </div>

    <!-- 하단 탭바: fullscreen이 아닐 때만 표시됨 -->
    <div v-if="!fullScreen" class="fixed-bottom d-md-none bg-white border-top h-10">

      <div class="menu menu-row d-flex justify-content-around py-2 fs-6 fw-bold cursor-pointer">

        <!-- 홈 탭 -->
        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'home') ? 'active' : ''"
             @click="tabButtonClicked('home')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-home fs-2x"></i>
          </span>
          <span class="menu-title">홈</span>
        </div>

        <!-- 찾기 탭 -->
        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'search') ? 'active' : ''"
             @click="tabButtonClicked('search')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-parcel-tracking fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
              </i>
          </span>
          <span class="menu-title">찾기</span>
        </div>

        <!-- 문서 탭 -->
        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'document') ? 'active' : ''"
             @click="tabButtonClicked('document')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-document fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
          </span>
          <span class="menu-title">게시물</span>
        </div>

        <!-- 더보기 탭 -->
        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'more') ? 'active' : ''"
             @click="tabButtonClicked('more')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-dots-circle fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
                <span class="path4"></span>
              </i>
          </span>
          <span class="menu-title">더보기</span>
        </div>

      </div>
    </div>
  </div>

  <!-- 드로어 (좌측 사이드 메뉴) -->
  <div id="kt_drawer_basic1"
       class="bg-white d-flex flex-column drawer-hidden"
       data-kt-drawer="true"
       data-kt-drawer-activate="true"
       data-kt-drawer-toggle="#kt_app_sidebar_mobile_toggle"
       data-kt-drawer-width="{default: '250px', 'md': '500px'}"
       data-kt-drawer-direction="start">

    <!-- 드로어 상단 -->
    <div class="p-5 border-bottom">
      <h3>메뉴</h3>
    </div>

    <!-- 드로어 메뉴 아이템 -->
    <div class="p-5">
      <div class="menu menu-column fs-6 fw-bold">

        <!-- 메뉴 항목 예시 -->
        <div class="menu-item">
          <div class="menu-link bg-light-primary text-primary px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-home fs-2x text-primary"></i>
            </span>
            <span class="menu-title m-2">홈</span>
          </div>
        </div>

        <div class="menu-item">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-parcel-tracking fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
                <span class="path3"></span>
              </i>
            </span>
            <span class="menu-title m-2">찾기</span>
          </div>
        </div>

        <div class="menu-item">
          <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-document fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
            </span>
            <span class="menu-title m-2">문서</span>
          </div>
        </div>

      </div>
    </div>

    <!-- 드로어 닫기 버튼 -->
    <div class="m-10">
      <button class="btn btn-sm btn-primary" @click="closeDrawer()">닫기</button>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from "vue-router";

// Vue Router 사용
const router = useRouter();

// Pinia 스토어 불러오기
import { storeToRefs } from "pinia";          // store 속성을 반응형으로 가져오기 위함
import { useAppStore } from "@/stores/app.js";
const appStore = useAppStore();              // 스토어 실행
const { title } = storeToRefs(appStore);     // title을 반응형으로 구조분해할당

// 하단 탭 상태
const activeTab = ref('home');

// 드로어 인스턴스 변수
let drawer;

// 컴포넌트 마운트 시 실행
onMounted(() => {
  console.log(`app::onMounted 호출됨.`);

  // Drawer 초기화 (KTDrawer 라이브러리)
  KTDrawer.createInstances();

  // 드로어 엘리먼트 가져오기
  const drawerElem = document.querySelector('#kt_drawer_basic1');
  drawer = KTDrawer.getInstance(drawerElem);

  // 드로어 이벤트 리스너
  drawer.on('kt.drawer.shown', () => {
    console.log(`Drawer가 보여짐`);
    drawerElem.classList.remove('drawer-hidden');
  })
  drawer.on('kt.drawer.hidden', () => {
    console.log(`Drawer가 사라짐`);
    drawerElem.classList.add('drawer-hidden');
  })
})

// 드로어 닫기 함수
function closeDrawer() {
  console.log(`closeDrawer 호출됨`);
  if (drawer) {
    drawer.hide();
  }
}

// 하단 탭 클릭 시 실행
function tabButtonClicked(name) {
  console.log(`tabButtonClicked 호출됨`);
  activeTab.value = name; // 현재 탭 갱신

  // 라우터 이동 분기
  if(name == 'home') {
    goToHome();
  } else if(name == 'search') {
    goToSearch();
  } else if(name == 'document') {
    goToDocument();
  } else if(name == 'more') {
    goToMore();
  }
}

// 라우터 이동 함수들
function goToHome() {
  router.push('/')
}
function goToSearch() {
  router.push('/search')
}
function goToDocument() {
  router.push('/document')
}
function goToMore() {
  router.push('/more')
}
function goToLogin() {
  fullScreen.value = true; // 로그인 화면은 전체화면 모드 전환
  router.push('/login')
}
</script>

<style scoped>
/* 디버깅용 보더 */
.my-border {
  border: 2px dashed violet;
}

/* 드로어 숨김 상태 */
.drawer-hidden {
  transform: translateX(-100%);
  visibility: hidden;
}

/* 드로어 보임 상태 */
.drawer-shown {
  visibility: visible;
}

/* 하단 탭 버튼 스타일 */
.tab-btn {
  padding: 4px 8px;
  border-radius: 8px;
  transition: all 0.25s ease-in-out;
}

/* 선택된 탭 스타일 */
.tab-btn.active {
  background-color: rgba(15, 110, 253, 0.1);
  color: var(--bs-primary) !important;
  border-radius: 8px;
  transform: scale(1.1);
}

.tab-btn .menu-icon {
  transition: color 0.25s ease-in-out;
}

.tab-btn.active .menu-icon i {
  color: var(--bs-primary) !important;
}
</style>
