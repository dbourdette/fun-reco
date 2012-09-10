package com.github.funreco

import com.github.funreco.service.OpenGraphQueryService

class QueriesController {

    OpenGraphQueryService openGraphQueryService

    def index() {

    }

    def add() {
        openGraphQueryService.add(params.query)

        redirect(uri : "/")
    }

    def delete() {
        openGraphQueryService.delete(params.id)

        redirect(uri : "/")
    }
}
