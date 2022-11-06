package ru.otus.otuskotlin.m3l4.ex2.b

interface RepositoryA
interface OtherService
class Request

class SomeService(
    private val repositoryA: RepositoryA,
    private val otherService: OtherService
) {
    fun processRequest(request: Request) {
        Processor().process(request)
    }

    inner class Processor {
        val otherService = 42

        fun process(request: Request) {
            step1(request)
            step2(request)
        }

        private fun step1(request: Request) {
            repositoryA
            this@SomeService.otherService
        }

        private fun step2(request: Request) {
            repositoryA
            this@SomeService.otherService
        }
    }
}

fun main() {
    val service = SomeService(object : RepositoryA {}, object : OtherService {})
    val processor = service.Processor()
    //val processor2 = SomeService.Processor()
}