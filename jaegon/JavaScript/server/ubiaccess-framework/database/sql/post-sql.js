module.exports = {
    post_list_all: {
        sql: `select id, title, contents, category,createDate, likes, comments,thumbnail
              from test.post`
    },post_list: {
        sql: `select id, title, contents, category,createDate, likes, comments,thumbnail
              from test.post`,
        count: `select count(*) as total
                from test.post`,
        where: ` where # `,
        order: ` order by # `,
        page: ` limit # `
    },

    post_read: {
        sql: `select id, title, contents, category,createDate, likes, comments,thumbnail
              from test.post
              where id = :id`
    },

    // 고객 데이터 추가
    post_add: {
        sql: `insert into test.post(title, contents, category,createDate, likes, comments,thumbnail)
              values
                  (:title, :contents, :category, :createDate, :likes, :comments, :thumbnail)`
    },

    // 고객 데이터 수정
    post_modify: {
        sql: `update test.post
              set title = :title,
                  contents = :contents,
                  category = :category,
                  createDate = :createDate,
                  likes = :likes,
                  comments = :comments,
                  thumbnail = :thumbnail
              where id = :id `
    },

    // 고객 데이터 삭제
    post_remove: {
        sql: `delete from test.post
              where id = :id `
    },

    // 좋아요 수 증가
    post_like: {
        sql: `update test.post
              set likes = likes + 1
              where id = :id `
    }

}