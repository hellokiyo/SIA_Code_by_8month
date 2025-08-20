<template>

  <!--상단 타이틀 추가하기-->
  <div class="d-flex flex-column h-100">

    <div class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">

      <button class="btn btn-icon btn-light">
        <i class="ki-duotone ki-arrow-left fs-2x text-primary">
          <i class="path1"></i>
          <i class="path2"></i>
        </i>
      </button>

      <span class="fs-2 fw-bold">안전등산</span>

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


      <div class="d-flex flex-row h-300px bg-secondary p-3">
        <!-- 첫 번째 컬럼 -->
        <div class="d-flex flex-center bg-primary w-200px border">
          <img src="@/assets/images/todayHike.png">
        </div>

        <!-- 두 번째 컬럼 -->
        <div class="d-flex flex-column flex-row-fluid">
          <div class="bg-warning d-flex flex-center flex-column-fluid">
            <span class="text-white">민원신청</span>
          </div>

          <div class="d-flex flex-column-fluid bg-danger flex-center">
            <span class="text-white">긴급</span>
          </div>
        </div>
      </div>


      <div class="d-flex flex-row border bg-secondary h-150px">

        <div class="flex-column-fluid bg-primary text-white">첫번째</div>
        <div class="flex-column-fluid bg-info text-white">두번째</div>

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


</template>

<script setup>


</script>

<style scoped>
.my-border {
  border: 2px dashed violet;
}

</style>

