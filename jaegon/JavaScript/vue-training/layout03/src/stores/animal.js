
import {computed, ref} from 'vue'
import { defineStore} from 'pinia'

export const useAnimalStore = defineStore('animal', ()=>{

    const animals = ref([])

    //추가, 수정 화면 중 어떤 모드인지 구분하기 위한 변수상자
    //  'add'  : 추가 모드
    //'modify' : 수정 모드
    const mode = ref('add')

    // 배열 안의 아이템 중에서 몇 번째 아이템이 선택되어있는지에 대한 인덱스 값
    const selectedIndex = ref(-1)



    return{
        animals, mode, selectedIndex
    }

})