
import{ ref } from 'vue'
import { defineStore} from 'pinia'

export const useAnimalStore = defineStore('animal', ()=>{

    const animals = ref([
        {
            id : 1,
            type : 'dog',
            name : '강아지1',
            age : 1,
            mobile : '010-1000-1000',
            path : '/images/dog1.png'
        },
        {
            id : 2,
            type : 'dog',
            name : '강아지2',
            age : 2,
            mobile : '010-2000-2000',
            path : '/images/dog2.jpg'
        },
        {
            id : 3,
            type : 'cat',
            name : '고양이1',
            age : 3,
            mobile : '010-3000-3000',
            path : '/images/cat1.jpg'
        },
        {
            id : 4,
            type : 'cat',
            name : '고양이2',
            age : 4,
            mobile : '010-4000-4000',
            path : '/images/cat2.jpg'
        }
    ])

    const selectedAnimal = ref('')
    return{
        animals
    }

})