//분리하고 싶은 코드를 이 파일에 넣어둠
const calc = {
    add: function (a, b) {
        return a + b;
    }
}

//calc 객체를 이 파일을 불러오기하는 쪽에서 사용할 수 있도록함
module.exports =  calc ;
