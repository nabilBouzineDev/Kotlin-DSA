import kotlin.math.abs

/**
 * We'll create a simple Map using the hash table approach,
 * It's a hybrid between a linked list and arrays.
 */

class MyMap {

    private inner class Item(val key: Any, var value: Any, var next: Item?)

    private val TABLE_SIZE = 8
    private val buckets = Array<Item?>(TABLE_SIZE) { null }
    var size = 0
        private set

    // operations:
    operator fun set(key: Any, value: Any) {
        // find correct bucket using key.hashCode()
        val bucket = abs(key.hashCode()) % TABLE_SIZE

        // Walk to the bucket to see if the item is already there
        var current = buckets[bucket]

        while (current != null) {
            if (current.key == key) {

                // 1. if yes -> change the value
                current.value = value
                return
            }
            current = current.next
        }

        // 2. otherwise -> add a node at the end.
        buckets[bucket] = Item(key, value, buckets[bucket])
        size++
    }

    operator fun get(key: Any): Any? {

        val bucket = abs(key.hashCode()) % TABLE_SIZE
        var current = buckets[bucket]

        while (current != null) {
            if (current.key == key) {

                return current.value
            }
            current = current.next
        }

        return null
    }
}


fun main() {

    val map = MyMap()


    map["test"] = "me"
    println(map["test"])
    assert(map.size == 1)
    map["tes"] = "me"
    println(map["tes"])
    assert(map.size == 2)
    map["test"] = "you"
    println(map["test"])
    assert(map.size == 2)
}