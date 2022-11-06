package ru.otus.otuskotlin.m3l4.ex2.a

interface RepositoryA
interface OtherService
class Request

class SomeService(
    private val repositoryA: RepositoryA,
    private val otherService: OtherService
) {
    fun processRequest(request: Request) {
        Processor(this).process(request)
    }

    private class Processor(val someService: SomeService) {
        fun process(request: Request) {
            step1(request)
            step2(request)
        }

        private fun step1(request: Request) {
            someService.repositoryA
            someService.otherService
        }

        private fun step2(request: Request) {
            someService.repositoryA
            someService.otherService
        }
    }
}