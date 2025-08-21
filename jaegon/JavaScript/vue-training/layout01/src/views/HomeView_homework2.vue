<template>

  <!-- 전체 레이아웃을 세로 방향 flex 컨테이너로 구성 -->
  <div class="d-flex flex-column h-100">

    <!-- 상단 헤더 (타이틀, 뒤로가기, 설정 버튼) -->
    <div class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">

      <!-- 뒤로가기 버튼 -->
      <button class="btn btn-icon btn-light">
        <i class="ki-duotone ki-arrow-left fs-2x text-primary">
          <i class="path1"></i>
          <i class="path2"></i>
        </i>
      </button>

      <!-- 중앙 타이틀 -->
      <span class="fs-2 fw-bold">안전등산</span>

      <!-- 설정 버튼 -->
      <button class="btn btn-icon btn-light">
        <i class="ki-duotone ki-setting-2 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

    </div>

    <!-- 메인 영역
         flex-grow-1 : 남는 공간 전부 차지
         overflow-auto : 내용이 넘치면 스크롤 생성
         p-10 p-lg-20 : 여백 설정
    -->
    <div class="flex-grow-1 overflow-auto bg-secondary p-10 p-lg-20 h-90 ">

      <!-- 첫 번째 행 : 이미지 + 민원신청/긴급 버튼 -->
      <div class="d-flex flex-row h-300px bg-secondary p-3">

        <!-- 첫 번째 컬럼 (등산 이미지) -->
        <div class="d-flex flex-center bg-primary w-200px border">

           <img class="flex-grow-1" src="@/assets/images/todayHike.png">

        </div>

        <!-- 두 번째 컬럼 (민원신청, 긴급 버튼) -->
        <div class="d-flex flex-column flex-row-fluid">

          <!-- 민원신청 영역 -->
          <div class="bg-warning d-flex flex-center flex-column-fluid mb-1">
            <span class="text-white">민원신청</span>
          </div>

          <!-- 긴급 영역 -->
          <div class="d-flex flex-column-fluid bg-danger flex-center mt-1">
            <span class="text-white">긴급</span>
          </div>

        </div>
      </div>

      <!-- 두 번째 행 : 두 개의 컬럼 -->
      <div class="d-flex flex-row border bg-secondary h-150px">

        <!-- 첫 번째 컬럼 -->
        <div class="flex-column-fluid bg-primary text-white m-1">첫번째</div>

        <!-- 두 번째 컬럼 -->
        <div class="flex-column-fluid bg-info text-white m-1" >두번째</div>

      </div>

    </div>

    <!-- 하단 탭 (모바일 전용)
         fixed-bottom : 화면 하단 고정
         justify-content-around : 버튼 균등 배치
    -->
    <div class="fixed-bottom d-md-none bg-white border-top h-10">

      <div class="d-flex justify-content-around align-items-center py-5">

        <!-- 홈 버튼 -->
        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>홈</span>
        </button>

        <!-- 찾기 버튼 -->
        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>찾기</span>
        </button>

        <!-- 문서 버튼 -->
        <button class="btn btn-light d-flex flex-column align-items-center w-80px">
          <span>문서</span>
        </button>

        <!-- 더보기 버튼 -->
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

</style>
