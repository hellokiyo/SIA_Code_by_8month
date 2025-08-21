<template>
  <div class="d-flex flex-column h-100">
    <!--
      d-flex 내부요소(버튼, 제목)들을 flex로 정렬
      flex-column 세로방향으로 정렬
      h-100 화면 꽉차게 height 100%
     -->


    <!-- 상단 헤더: fullscreen이 아닐 때만 보임 -->
    <div v-if="!fullScreen" class="app-header d-flex align-items-center justify-content-between border-bottom bg-white p-2">
      <!--
      v-if="!fullScreen" 화면이 꽉차지 않았을때 (앱 화면)
      d-flex (default : flex- row)  d-flex만 쓰면 기본값이 row임 > 가로정렬
      justify-content-between 양 끝 배치하고 그 사이 균등한 공간 두기
      border-bottom 아래쪽 얇은 테두리 선 추가
      bg-white 배경색 흰색
      p-2 상하좌우에 2단계 크기의 여백을 줌

      -->
      <!-- 좌측 햄버거 버튼 (드로어 열기용) -->
      <button class="btn btn-icon btn-light" id="kt_app_sidebar_mobile_toggle">
        <!--메뉴창
        btn 부트스트랩 버튼 스타일 적용
        btn-icon 버튼안에 아이콘만 들어갈때 사용
        btn-light 연한 회색 배경 버튼 스타일 적용
        id 메트로닉식 이름짓기 사이드바에 이벤트기능 추가하기 위한 id값 부여
        -->

        <i class="ki-duotone ki-abstract-14 fs-2x text-primary">
          <!--Keenicons 라이브러리 - 메트로닉 사이트 -icon - keenicon - ctrl+f로 원하는 기능 찾기 복붙 하면 됨
          ki-abstract-14 아이콘 구체적인 모양
          fs-2x 글꼴크기 2배 키우기
          text-primary 텍스트(아이콘) 색상 파란색 지정
          -->
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

      <!-- 가운데 타이틀 (Pinia store의 title 값 표시) -->
      <span class="fs-2 fw-bold "@click="goToHome">{{ title }}</span>
      <!--
      fs-2 글꼴 크기 크게 만들기
      fw-bold > bolod체 글씨 굵게
      @click="goToHome" 클릭시 함수실행하는 이벤트 리스너
      {{ title }} 데이터 바인딩 title변수값을 동적으로 가져오기
      -->
      <!-- 우측 로그인 버튼 -->
      <button class="btn btn-icon btn-light" @click="goToLogin()">
        <i class="ki-duotone ki-setting-2 fs-2x text-primary">
          <span class="path1"></span>
          <span class="path2"></span>
        </i>
      </button>

    </div>

    <!-- 메인 컨텐츠 -->
    <div class="flex-grow-1 overflow-auto bg-light p-4" style="padding-bottom: 80px;">
      <!--
      flex-grow-1 > 화면에서 사용가능한 남은공간 모두 차지
      overflow-auto  > 내용 넘칠 경우 스크롤 기능
      bg-light > 배경색 연한회색(메트로닉)
      p-4 > 상하좌우 패딩 4
      -->
      <!-- 추천 섹션 -->
      <div class="row g-3 mb-5">
        <!--
        row > 가로로 나열한 그리드
        g-3 > 카드 사이간격 3단계로 설정
        mb-5 > 마진 바텀 5단계 크기
        -->

        <!--오늘의 등산로 카드-->
        <div class="col-6">
          <!--
          화면을 12칸으로 나눴을때 세로로 6칸 차지하는 영역 만들기
          -->
          <div class="card text-white h-100"
               :style="{
                   backgroundImage: `url(${cards[0].bg})`,
                   backgroundSize: 'cover',
                   backgroundPosition: 'center'}"
          ><!--
           text-white > 흰색 글씨
           h-100 > height -100% 부모요소의 높이에 맞게 꽉차게
           :style 동적 스타일속성 바인딩
           backgroundImage: `url(${cards[0].bg})` > 배경 이미지 url 설정 > 배열에 들어있는 bg값으로 지정
           backgroundSize: 'cover',  배경 이미지가 카드를 꽉 채우기
           backgroundPosition: 'center'}" 배경이미지를 중앙 위치
          -->

            <div class="card-body d-flex flex-column justify-content-center">
              <!--
              card-body card-body의 설정을 가져옴
              justify-content-center 자식 요소를 가운데 정렬
              -->
              <h5 class="text-white fw-bold mb-2">{{cards[0].title}}</h5>
              <span class="text-white-75">{{cards[0].ex}}</span>
            </div>
          </div>
        </div>

        <!--오늘의 민원신청, 긴급 카드-->
        <div class="col-6">
          <div class="card text-white h-100">
            <!--민원신청 카드-->
            <div class="card-body bg-warning d-flex flex-column justify-content-center mb-1" style="border-radius: 8px"
                 :style="{
                   backgroundImage: `url(${cards[1].bg})`,
                   backgroundSize: 'cover',
                   backgroundPosition: 'center'}"
            >
              <h5 class="text-white fw-bold mb-2">{{cards[1].title}}</h5>
              <span class="text-white">{{cards[1].ex}}</span>
            </div>

            <!--긴급 카드-->
            <div class="card-body bg-warning d-flex flex-column justify-content-center mb-1" style="border-radius: 8px"
                 :style="{
                   backgroundImage: `url(${cards[2].bg}) !important`,
                   backgroundSize: 'cover',
                   backgroundPosition: 'center'
                 }"
            >
              <h5 class="text-white fw-bold mb-2">{{cards[2].title}}</h5>
              <span class="text-white">{{cards[2].ex}}</span>
            </div>
          </div>
        </div>

        <!--등산 카드-->
        <div  v-for="n in 2" :key="n+4" class="col-6">
          <div class="card text-white h-100"
               :style="{
                   backgroundImage: `url(${cards[n+2].bg})`,
                   backgroundSize: 'cover',
                   backgroundPosition: 'center'}"
          >
            <div class="card-body d-flex flex-column justify-content-center">
              <h5 class="text-white fw-bold mb-2">{{cards[n].title}}</h5>
              <span class="text-white">{{cards[n].ex}}</span>
            </div>
          </div>
        </div>


        <!--커뮤니티 카드
        <div class="col-6">
          <div class="card text-white h-100"
               :style="{
                   backgroundImage: `url(${cards[4].bg})`,
                   backgroundSize: 'cover',
                   backgroundPosition: 'center'}"
          >
            <div class="card-body d-flex flex-column justify-content-center">
              <h5 class="text-white fw-bold mb-2">{{cards[4].title}}</h5>
              <span class="text-white">{{cards[4].ex}}</span>
            </div>
          </div>
        </div>-->
      </div>


      <div class="mb-4">
        <h5 class="fw-bold mb-3">어서와 등산은 처음이지?</h5>
        <span class="text-gray-600 ">요즘 뜨는 등산멘트</span>
        <div class="d-flex flex-row overflow-auto">
          <div v-for="n in 6" :key="n" class="me-3">
            <div class="symbol symbol-60px">
              <img :src="`/assets/media/avatars/300-${n}.jpg`"/>
            </div>
          </div>
        </div>
      </div>

      <!-- 지금 가장 핫한 게시물 -->
      <div class="mb-20">
        <h5 class="fw-bold mb-5">지금 가장 핫한 게시물 🔥</h5>
        <div class="d-flex flex-row overflow-auto">
          <div v-for="n in 3" :key="n" class="me-3">
            <div class="card h-100 w-200px">
              <img :src="`/assets/media/books/${n}.png`"/>
              <div class="card-body">
                <h6 class="fw-bold">게시물 {{ n }}</h6>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

    <!-- 하단 탭 -->
    <div class="fixed-bottom d-md-none bg-white border-top">
      <div class="menu menu-row d-flex justify-content-around py-2 fs-6 fw-bold cursor-pointer">
        <div v-for="tab in tabs" :key="tab.key"
             class="menu-item flex-column align-items-center flex-fill tab-btn"
             :class="{active: activeTab===tab.key}"
             @click="tabButtonClicked(tab.key)">
          <span class="menu-icon mb-1" v-html="tab.icon">
          </span>
          <span class="menu-title">{{tab.title}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

import { ref } from 'vue'
import { useRouter} from "vue-router";
const router = useRouter();

// Pinia 스토어 불러오기
import { storeToRefs } from "pinia";          // store 속성을 반응형으로 가져오기 위함
import { useAppStore } from "@/stores/app.js";
const appStore = useAppStore();              // 스토어 실행
const { title } = storeToRefs(appStore);     // title을 반응형으로 구조분해할당

const activeTab = ref('home')

//전체 화면으로 보일 것인지의 여부
const fullScreen = ref(false)


// 하단 탭의 버튼이 눌렸을 때
function tabButtonClicked(name) {
  console.log(`tabButtonClicked 호출됨`);

  activeTab.value = name;

  //메인 영역의 화면 전환하기
  if(name === 'home') {
    goToHome();
  }else if(name === 'search') {
    goToSearch();
  }
  else if(name === 'document') {
    goToDocument();
  }
  else if(name === 'more') {
    goToMore();
  }
}

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
  fullScreen.value =true;

  router.push('/login')
}


// cards에 json형식으로 객체 생성
const cards =ref( [
  { id :1, title: '오늘의 등산로', ex: '등산로 보기', bg: '/assets/media/stock/600x400/img-20.jpg' },
  { id :2, title: '민원신청', ex: '불편, 개선사항 접수', bg: '/assets/media/stock/600x400/img-15.jpg' },
  { id :3, title: '긴급', ex: 'sos신고', bg: '/assets/media/stock/600x400/img-24.jpg' },
  { id :4, title: '등산', ex: '나만의 등산기록', bg: '/assets/media/stock/600x400/img-18.jpg' },
  { id :5, title: '커뮤니티', ex: '#오등완 #등린이', bg: '/assets/media/stock/600x400/img-25.jpg' }

])

const tabs = ref([
  { key: 'home', title: '홈', icon: '<i class="ki-duotone fs-2x ki-home">\n</i>' },
  { key: 'search', title: '검색', icon: '<i class="ki-duotone fs-2x ki-map">\n' +
        ' <span class="path1"></span>\n' +
        ' <span class="path2"></span>\n' +
        ' <span class="path3"></span>\n' +
        '</i>' },
  { key: 'document', title: '문서', icon: '<i class="ki-duotone fs-2x ki-people">\n' +
        ' <span class="path1"></span>\n' +
        ' <span class="path2"></span>\n' +
        ' <span class="path3"></span>\n' +
        ' <span class="path4"></span>\n' +
        ' <span class="path5"></span>\n' +
        '</i>'}

])



</script>

<style scoped>
.tab-btn {
  padding: 4px 8px;
  border-radius: 8px;
  transition: all 0.25s ease-in-out;
}
.tab-btn.active {
  background-color: rgba(15,110,253,0.1);
  color: var(--bs-primary) !important;
}
.tab-btn.active .menu-icon i {
  color: var(--bs-primary) !important;
}
</style>
