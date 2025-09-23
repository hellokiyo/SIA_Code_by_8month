///
///OpenAI
///

import OpenAI from 'openai';

const OpenAIKey = '';

const openai = new OpenAI({
    apiKey : OpenAIKey
})

const messages = [
    {
        role : 'system',
        content : '너는 음식점에 대해서 잘 알고 있는 전문가야. ' +
            '위치를 기준으로 해서 주변에 있는 음식점을 추천해줘 ' +
            '음식에 대한 설명, 경위도 좌표 표시해줘. ' +
            '웹 사이트를 검색해서 최신 정보를 확인한 후에 답변해줘. ' +
            '웹사이트를 검색했을때 결과가 나오지 않는 정보는 제외해줘',

    },
    {
        role : 'user',
        content: '내 위치는 구로구청이야.' +
            '도로명 주소는 가마산로 242야' +
            '나는 10000원 안에서 밥을 해결하고 싶어' +
            '나는 구글 지도를 이용해' +
            '도보 10분 이내였음 좋겠어' +
            ''
    },
    {
        role : 'assistant',
        content: ` 1.고기리 막창** ###설명   - 전문 막창집으로, 신선한 재료와 함께 맛있는 고기를 즐길 수 있습니다.\\n\\n2. 2.신사임당\\n ###설명  - 전통 한정식을 제공하는 곳으로, 다양한 한식 메뉴가 있어요. 한식이 생각날 때 좋습니다.\\n\\n3. 3.스시 메루\\n ###설명 신선한 스시와 사시미를 제공하는 일식집입니다. 깔끔한 인테리어와 함께 부담 없이 즐길 수 있는 가격대가 매력적입니다.\\n\\n`
    }
]


const doPrompt =  async (input) => {
    try {

        messages.push(
            {
                role : 'user',
                content : input
            }
        )
        const response = await openai.chat.completions.create({
            model : 'gpt-4o-mini',
            messages : messages
        })

        //console.log(`response => ${JSON.stringify(response)}`)

        const output = {
            role : response.choices[0].message.role,
            content: response.choices[0].message.content
        }

        return output;
    }catch(err) {
        throw new Error(`Error-> ${err}`)
    }
    
}

const  input = `내위치는 '구로구청'이야`;

(async ()=> {  // 실행시키면 작동 한번만 실행 일회용품
    try{
        const output = await doPrompt(input)
        console.log(`요약결과 -> ${JSON.stringify(output)}`)

    }catch(err) {
        console.log(`요약 과정에서 에러 -> ${err}`)
    }
})();