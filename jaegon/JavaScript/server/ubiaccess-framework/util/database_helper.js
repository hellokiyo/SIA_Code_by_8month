class DatabaseHelper {
    constructor(db) {
        this.database = db;

    }

    async query(sqlName,params) {

        const queryParams = {
                sqlName: sqlName,
                params: params,
                paramType: {}
        }

        const rows = await this.database.execute(queryParams);

        return rows;
    }
}

module.exports = DatabaseHelper;
