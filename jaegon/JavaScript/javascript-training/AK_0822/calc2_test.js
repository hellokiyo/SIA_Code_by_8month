//calc2.js 모듈에 있는 여러개의 함수 중에서 add 함수만 불러오기
const { add } = require('./calc2');

const result = add(10, 10);
console.log(`더하기 결과 : ${result}`);