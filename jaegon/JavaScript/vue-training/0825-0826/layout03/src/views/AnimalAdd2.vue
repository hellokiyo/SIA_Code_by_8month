
<template>
  <div>
    <div>
      <h1>추가 화면</h1>
    </div>

    <!-- v-for로 바꾸기
    <div v-for="(item,index) in animal_info" :key="index">
      <div>
        <label>{{item.label}}</label>
        <input type="text" v-model="animals[item.model]">
      </div>
    </div>-->




    <div>
      <label>구분</label>
      <input type="text" v-model="typeInput">
    </div>

    <div>
      <label>이름</label>
      <input type="text" v-model="nameInput">
    </div>

    <div>
      <label>나이</label>
      <input type="text" v-model="ageInput">
    </div>

    <div>
      <label>전화번호</label>
      <input type="text" v-model="mobileInput">
    </div>

    <div>
      <label>이미지 경로</label>
      <input type="text" v-model="pathInput">
    </div>

    <div style="margin-top: 2em">
        <button @click="save()">저장</button>
        <button @click="cancel()">취소</button>
    </div>
  </div>
</template>


<script setup>
//스토어(공통저장소에 있는 것 사용하기
import { storeToRefs } from "pinia";

import { useAnimalStore } from '@/stores/animal'
import { ref, onMounted} from "vue";

import { useRouter } from "vue-router";
import axios from "axios";
const router = useRouter()

const animalStore = useAnimalStore()
const { animals, mode, selectedIndex } =storeToRefs(animalStore)


/* v-for사용시 오픈
const animal_info = [
  {
    label : '구분',
    model : 'type'
  },
  {
    label : '이름',
    model : 'name'
  },
  {
    label : '나이',
    model : 'age'
  },
  {
    label : '전화번호',
    model : 'mobile'
  },
  {
    label : '이미지',
    model : 'path'
  }
]*/

const typeInput = ref('')
const nameInput = ref('')
const ageInput = ref('')
const mobileInput = ref('')
const pathInput = ref('')

// 화면이 보이기 전에 한 번 실행됨
// 목적 : 화면이 보이기 전에 초기화하거나 또는 실행해야 하는 것들을 실행해줌
onMounted(()=> {
  console.log(`AnimalAdd::onMounted 호출됨`)

  // 수정 모드인 경우, 입력상자에 선택된 아이템의 값을 넣어주기
  if(mode.value == 'modify'){
    const selected = animals.value[selectedIndex.value]

    typeInput.value = selected.type
    nameInput.value = selected.name
    ageInput.value = selected.age
    mobileInput.value = selected.mobile
    pathInput.value = selected.path

  }
})





function save() {
  console.log(`save 함수 호출됨`)

  const type = typeInput.value
  const name = nameInput.value
  const age = ageInput.value
  const mobile = mobileInput.value
  const path = pathInput.value

  const item = {
    //id : String(animals.length +1),
    type : type,
    name : name,
    age : age,
    mobile : mobile,
    path : path
  }

  if (mode.value === 'add'){

    requestAnimalAdd(item)

  }

  else if (mode.value === 'modify'){

    item.id = animals.value[selectedIndex.value].id

    requestAnimalModify(item)

  }
}

async function requestAnimalAdd(item) {
  try{

    const response = await axios({
      method: 'post',
      baseURL: `http://localhost:8001`,
      url: '/animal/v1/add',
      data: item,
      timeout: 5000,
      responseType: "json"
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    animals.value = response.data.data.data

    goToList()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

async function requestAnimalModify(item) {
  try{

    const response = await axios({
      method: 'post',
      baseURL: `http://localhost:8001`,
      url: '/animal/v1/modify',
      data: item,
      timeout: 5000,
      responseType: "json"
    })

    console.log(`응답 -> ${JSON.stringify(response.data)}`)

    goToList()

  } catch (err) {
    console.error(`에러 -> ${err}`);
  }
}

function goToList(){
  router.replace('/',{})
}

function cancel() {
  console.log('cancel 함수 호출됨')

  router.replace('/',{})
}





</script>



<style scoped>

</style>