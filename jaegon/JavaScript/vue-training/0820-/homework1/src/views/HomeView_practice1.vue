<template>

  <!--상단 타이틀 추가하기-->
  <div class="d-flex flex-column h-100">

    <div class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">

      <button class="btn btn-icon btn-light" id="kt_app_sidebar_mobile_toggle">
        <i class="ki-duotone ki-abstract-14">
          <i class="path1"></i>
          <i class="path2"></i>
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

    <!--메인 영역, flex-grow-1 : 남아있는 여유공간을 모두 차지함,
    overflow-auto : 내용물이 화면 영역을 넘어가는 경우 스크롤이 자동으로 생김
    bg-md-danger
    -->
    <div class="flex-grow-1 overflow-auto bg-secondary p-10 p-lg-20 h-90 ">

      <h1>메인 영역</h1>

      <div class="d-flex flex-col border h-100px">

        <div class="flex-fill bg-primary text-white">첫번째</div>

      </div>

      <div class="d-flex flex-col border h-200px">

        <div class="flex-fill bg-primary text-white">첫번째</div>
        <div class="flex-fill bg-info text-white">두번째</div>

      </div>

      <div class="d-flex flex-row border h-200px">

        <div class="flex-fill bg-primary text-white">첫번째</div>
        <div class="flex-fill bg-info text-white">두번째</div>
        <div class="flex-fill bg-success text-white">세번째</div>

      </div>


      <div class="d-flex flex-column border h-200px">

        <div class="h-50px bg-primary text-white">첫번째</div>
        <div class="flex-grow-1 bg-info text-white">두번째</div>
        <div class="h-50px bg-success text-white">세번째</div>

      </div>

    </div>
    <!-- 하단 탭, fixed-bottom 화면 맨 아래에 고정시킴,
                 justify-content-around : 버튼들을 가로 방향으로 균등 배치함-->
    <div class="fixed-bottom d-md-none bg-white border-top h-10">

      <div class="d-flex justify-content-around align-items-center py-5">

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>홈</span>
        </button>

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>찾기</span>
        </button>

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>문서</span>
        </button>

        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>더보기</span>
        </button>

      </div>
    </div>
  </div>

  <!--드로어-->
  <div id="kt_drawer_basic1"
       class="bg-white d-flex flex-column drawer-hidden"
       data-kt-drawer="true"
       data-kt-drawer-activate="true"
       data-kt-drawer-toggle="#kt_app_sidebar_mobile_toggle"
       data-kt-drawer-width="{default: '250px', 'md' :'500px'}"
       data-kt-drawer-direction="start"
  >
  <div class ="p-5 border-bottom">
    <h3>메뉴</h3>
  </div>

  </div>

  <div class="p-5">

    <div class="menu menu-column fs-6 fw-bold">

      <div class="menu-item ">
        <div class="menu-link bg-light-primary text-primary px-4 py-2 rounded">
          <span class="menu-icon fs-2x">
            <i class="ki-duotone ki-home">
            </i>
          </span>
          <span class="menu-title m-2">홈</span>
        </div>

        <div class="menu-link bg-light-secondary text-dark px-4 py-2 rounded">
          <span class="menu-icon">
            <i class="ki-duotone ki-search-list fs-2x">
             <span class="path1"></span>
             <span class="path2"></span>
             <span class="path3"></span>
            </i>
          </span>
          <span class="menu-title m-2">찾기</span>
        </div>

        <div class="menu-link bg-light-secondary text-primary px-4 py-2 rounded">
          <span class="menu-icon">
            <i class="ki-duotone ki-document fs-2x" >
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </span>
          <span class="menu-title m-2">문서</span>
        </div>
      </div>

    </div>
  </div>

</template>

<script setup>

import {ref, onMounted} from "vue";

// 화면이 보이기 전에 한 번 호출됨
onMounted(()=> {
  console.log(`Homeview::onMounteed 호출됨.`)

  //Drawer 설정
  const drawerElem = document.querySelector('#kt_drawer_basic1')
  const drawer = KTDrawer.getInstance(drawerElem)
  drawer.on('kt.drawer.shown', ()=> {
    console.log(`Drawer가 보여짐`)
    drawerElem.classList.remove('drawer-hidden')
  })
  drawer.on('kt.drawer.hidden', ()=> {
    console.log(`Drawer가 사라짐`)
    drawerElem.classList.add('drawer-hidden')
  })
})

</script>

<style scoped>

.my-border {
  border: 2px dashed violet;
}

.drawer-hidden {
  transform: translateX(-100%);
  visibility: hidden;
}

.drawer-shown {
  visibility: visible;
}

</style>

