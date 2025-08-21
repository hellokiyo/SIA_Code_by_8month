<template>

  <!--flex를 이용해 쌓기, d-flew : Flex를 사용함, 기본 은 가로로 쌓기가(flex-row), 세로로 쌓기(flex-column) -->
  <div class="d-flew flew-column">



    <!--
    bg- 백그라운드
    p - 패딩
    자식들의 요소 사이 띄우기 gap-2
    btn-primary 버튼 파랑
    -->
    <div class = "d-flex bg-seconddary my-border gap-2 p-10">
      <button class = "btn btn-primary">버튼 1</button>
      <button class = "btn btn-primary">버튼 2</button>
      <button class = "btn btn-primary">버튼 3</button>
    </div> 

    <div class = "d-flex flex-column bg-seconddary my-border gap-2 p-10">
      <button class = "btn btn-primary">버튼 1</button>
      <button class = "btn btn-primary">버튼 2</button>
      <button class = "btn btn-primary">버튼 3</button>
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

