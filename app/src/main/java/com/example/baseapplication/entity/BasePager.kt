package com.example.baseapplication.entity


/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-18
 */
class BasePager {
    private var index = 1

    var size: Int = 0
        private set

    private val count: Int = 0
    var total: Long = 0

    fun getIndex(): Int {
        if (total != 0L && index == 0) {
            index = 1
        }
        return index
    }

    fun setIndex(index: Int?) {
        this.index = index!!
    }

    fun setSize(size: Int?) {
        this.size = size!!
    }

    fun getCount(): Int {
        val mod = total % size
        var count = total / size
        count = if (mod == 0L) count else count + 1
        return count.toInt()
    }

    constructor(index: Int, size: Int) {
        if (index > 0) {
            this.index = index
        } else {
            this.index = 1
        }
        if (size in 1..200) {
            this.size = size
        } else {
            this.size = 10
        }
    }
}