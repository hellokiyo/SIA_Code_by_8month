<template>

  <!-- 상단 타이틀 추가하기 -->
  <div class="d-flex flex-column h-100">

    <div class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">

      <button class="btn btn-icon btn-light" id="kt_app_sidebar_mobile_toggle">
        <i class="ki-duotone ki-abstract-14 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

      <span class="fs-2 fw-bold">제목</span>

      <button class="btn btn-icon btn-light">
        <i class="ki-duotone ki-setting-2 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

    </div>

    <!-- 메인 영역 -->
    <div class="flex-grow-1 overflow-auto bg-light p-3">
      <div class="d-flex flex-row h-200px mb-3">

        <!-- 왼쪽 컬럼 -->
        <div class="flex-fill d-flex flex-column me-2">
          <!-- 오늘의 등산로 (위쪽 큰 영역) -->
          <div class="flex-fill bg-primary text-white d-flex align-items-center justify-content-center mb-2 rounded">
            <div class="text-center">
              <div class="fw-bold">오늘의 등산로</div>
              <small>추천 코스</small>
            </div>
          </div>
          <!-- 하단 두 개 영역 -->
          <div class="d-flex flex-row h-80px">
            <div class="flex-fill bg-info text-white d-flex align-items-center justify-content-center me-1 rounded">
              <small>등산<br>나만의 등산기록</small>
            </div>
            <div class="flex-fill bg-primary text-white d-flex align-items-center justify-content-center ms-1 rounded">
              <small>지휘센터<br>구조요청 및 신고</small>
            </div>
          </div>
        </div>

        <!-- 오른쪽 컬럼 -->
        <div class="flex-fill d-flex flex-column ms-2">
          <!-- 민원신청 -->
          <div class="bg-warning text-white d-flex align-items-center justify-content-center mb-2 rounded h-60px">
            <div class="text-center">
              <div class="fw-bold">민원신청</div>
              <small>간편하게 신청하세요</small>
            </div>
          </div>
          <!-- 긴급 -->
          <div class="flex-fill bg-danger text-white d-flex align-items-center justify-content-center rounded">
            <div class="text-center">
              <div class="fw-bold">긴급</div>
              <small>SOS 신고</small>
            </div>
          </div>
        </div>
      </div>

      <!-- 어서와 등산은 처음이지? 섹션 -->
      <div class="mb-4">
        <h6 class="fw-bold mb-3 text-dark">어서와 등산은 처음이지?</h6>
        <div class="d-flex justify-content-between">
          <div class="rounded-circle overflow-hidden w-60px h-60px d-flex align-items-center justify-content-center bg-light">
            <img class="object-contain w-100 h-100" src="@/assets/images/climb.png">
          </div>
          <div class="rounded-circle overflow-hidden w-60px h-60px d-flex align-items-center justify-content-center bg-light">
            <img class="object-contain w-100 h-100" src="@/assets/images/people.png">
          </div>
          <div class="rounded-circle overflow-hidden w-60px h-60px d-flex align-items-center justify-content-center bg-light">
            <img class="object-contain h-60px w-60px" src="@/assets/images/clock.png">
          </div>
          <div class="rounded-circle overflow-hidden w-60px h-60px d-flex align-items-center justify-content-center bg-light">
            <img class="object-contain w-100 h-100" src="@/assets/images/mountaion.png">
          </div>
          <div class="rounded-circle overflow-hidden w-60px h-60px d-flex align-items-center justify-content-center bg-light">
            <img class="object-contain w-100 h-100" src="@/assets/images/map.png">
          </div>
        </div>
      </div>

      <!-- 지금 가장 화한 계절별 섹션 -->
      <div class="mb-4">
        <h6 class="fw-bold mb-3 text-dark">지금 가장 화한 계절별</h6>
        <div class="d-flex flex-row h-100px">
          <div class="flex-fill bg-primary text-white d-flex align-items-center justify-content-center me-2 rounded">
            <span class="text-center">봄 등산로</span>
          </div>
          <div class="flex-fill bg-info text-white d-flex align-items-center justify-content-center ms-2 rounded">
            <span class="text-center">겨울 등산로</span>
          </div>
        </div>
      </div>

    </div>

    <!-- 하단 탭 -->
    <div class="fixed-bottom d-md-none bg-white border-top">

      <div class="menu menu-row d-flex justify-content-around py-2 fs-6 fw-bold cursor-pointer">

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'home') ? 'active' : ''"
             @click="tabButtonClicked('home')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-home fs-2x">
              </i>
          </span>
          <span class="menu-title">홈</span>
        </div>

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

        <div class="menu-item flex-column align-items-center flex-fill mx-4 tab-btn"
             :class="(activeTab == 'document') ? 'active' : ''"
             @click="tabButtonClicked('document')">
          <span class="menu-icon mb-1">
              <i class="ki-duotone ki-document fs-2x">
                <span class="path1"></span>
                <span class="path2"></span>
              </i>
          </span>
          <span class="menu-title">문서</span>
        </div>

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

  <!-- 드로어 -->
  <div id="kt_drawer_basic1"
       class="bg-white d-flex flex-column drawer-hidden"
       data-kt-drawer="true"
       data-kt-drawer-activate="true"
       data-kt-drawer-toggle="#kt_app_sidebar_mobile_toggle"
       data-kt-drawer-width="{default: '250px', 'md': '500px'}"
       data-kt-drawer-direction="start"
  >

    <div class="p-5 border-bottom">
      <h3>메뉴</h3>
    </div>

    <div class="p-5">

      <div class="menu menu-column fs-6 fw-bold">

        <div class="menu-item">
          <div class="menu-link bg-light-primary text-primary px-4 py-2 rounded">
            <span class="menu-icon">
              <i class="ki-duotone ki-home fs-2x text-primary">
              </i>
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

    <div class="m-10">

      <button class="btn btn-sm btn-primary" @click="closeDrawer()">닫기</button>

    </div>


  </div>


</template>

<script setup>

import {onMounted, ref} from 'vue'


let drawer;

const activeTab = ref('home');


// 화면이 보이기 전에 한 번 호출됨
onMounted(() => {
  console.log(`HomeView::onMounted 호출됨.`);

  // Drawer 설정
  KTDrawer.createInstances();

  const drawerElem = document.querySelector('#kt_drawer_basic1');
  drawer = KTDrawer.getInstance(drawerElem);
  drawer.on('kt.drawer.shown', () => {
    console.log(`Drawer가 보여짐`);

    drawerElem.classList.remove('drawer-hidden');
  })
  drawer.on('kt.drawer.hidden', () => {
    console.log(`Drawer가 사라짐`);
    drawerElem.classList.add('drawer-hidden');
  })

})


// 드로어 안에 있는 [닫기] 버튼을 눌렀을 때
function closeDrawer() {
  console.log(`closeDrawer 호출됨`);

  if (drawer) {
    drawer.hide();
  }

}

// 하단 탭의 버튼이 눌렸을 때
function tabButtonClicked(name) {
  console.log(`tabButtonClicked 호출됨`);

  activeTab.value = name;
}


</script>

<style scoped>

.my-border {
  border: 2px dashed violet;
}

/* 드로어 */
.drawer-hidden {
  transform: translateX(-100%);
  visibility: hidden;
}

.drawer-shown {
  visibility: visible;
}

/* 탭버튼 */
.tab-btn {
  padding: 4px 8px;
  border-radius: 8px;
  transition: all 0.25s ease-in-out;
}

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
