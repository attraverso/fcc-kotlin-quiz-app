fun main(args: Array<String>) {
    printLists()
    printSets()
    printSetsWithCustomObjects()
    printMaps()
}

fun printLists() {
    // you can add the type or not here, the string type can be inferred
    val immutableList = listOf("name1", "name2", "name3", "name1")
    // if you print the whole list, name1 will appear twice
    println("immutableList $immutableList")

    val mutableList = mutableListOf("name1", "name2", "name3", "name1")
    mutableList.add("name4")
    mutableList.removeAt(0)
    mutableList.forEach { println("mutableList: $it")}
}

fun printSets() {
    val immutableSet = setOf<String>("name1", "name2", "name3", "name1")
    // whether you print the whole list or loop through it, name1 will only appear once
    // as sets only store unique elements
    println("immutableSet $immutableSet")
    immutableSet.forEach { println("immutableSet: $it")}

    val mutableSet = mutableSetOf("name1", "name2", "name3", "name1")
    mutableSet.add("name4")
    mutableSet.remove("name1")
    mutableSet.forEach { println("mutableSet: $it")}
}

fun printSetsWithCustomObjects() {
    val user1 = User("Alex")
    val user2 = User("Paul")
    val user3 = User("Julie")
    val user4 = User("Aaron")
    val user5 = User("Alexis")
    val user6 = User("Alexis")

    val mutableSet = mutableSetOf<User>(user1,user2,user3,user4,user5,user6)
    // with a normal class declaration we get Alexis twice, because the set uses the equalsTo function to determine
    // whether items are unique, and our user class has no override for that method,
    // so it can't guess a way to determine equality
    mutableSet.forEach { println(it.name) }
}

// see printSetsWithCustomObjects()
class User(val name: String)

// if we use the data keyword, though, it'll use an auto-generated equalsTo function
// data class User(val name: String)

fun printMaps() {
    val immutableMap = mapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John")
    // here 1 is the key, not the index. Keys are of course unique.
    println(immutableMap[1])

    val mutableMap = mutableMapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John")
    mutableMap[5] = "Aaron"
    mutableMap.remove(3)
    mutableMap.forEach { t, u ->
        println("$t is $u")
    }
    // here 2 is the key, not the index
    println(mutableMap[2])
}