const util = require('./util');
const param = require('./param');


const DatabaseHelper = require('./database_helper');

class ControllerHelper {

    constructor(db) {
        this.databaseHelper = new DatabaseHelper(db);
    }

    async execute(req, res, sqlName) {

        const params = param.parse(req);

        try {

            const rows = await this.databaseHelper.query(sqlName,params);

            const output = {
                header: {

                },
                data :rows
            }

            util.sendRes(res, 200, 'OK', output );

        } catch (err) {
            util.sendError(res, 400, `Error -> ${err}`)
        }

    }

}

module.exports = ControllerHelper;