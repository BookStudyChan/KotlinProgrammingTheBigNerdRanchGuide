fun main(args: Array<String>) {
    val option = 5
    when(option)
    {
        5-> chapter5()
        4-> chapter4()
        else -> return
    }

}


private fun chapter5(){
    //5장
    // 익명함수 p79
    // 암시적 반환 p 81
    // 익명함수는 암시적으로 가장 마지막줄을 자동으로 return 해주는 함시적 반환을 사용한다.
    println({
        val currentYear = 2020
        "SimVillage 방문을 환영합니다. (copyright $currentYear)"
    }())

    // 함수 타입 p 80
    // 함수 인자 p 82
    val greetingFunction : (String, Int) ->String = { playerName, numBuildings->
        val currentYear = 2020
        println("$numBuildings 채 건물이 추가됨")
        "SimVillage 방문을 환영합니다. $playerName 님! (copyright $currentYear)"
    }
    println(greetingFunction("chad", 2))


    // it 키워드 p 83
    // 하나의 이니자만 받는 익명함수의 경우 이처럼 it 을 사용하여 제작 할 수 있다.
    val greetingFunction2 : (String) ->String = {
        val currentYear = 2020
        "SimVillage 방문을 환영합니다. $it 님! (copyright $currentYear)"
    }
    println(greetingFunction2("chad"))

    // 타입 추론 지원 p 85
    val greetingFunction3 = { playerName:String, numBuildings:Int ->
        val currentYear = 2020
        println("$numBuildings 채 건물이 추가됨")
        "SimVillage 방문을 환영합니다. $playerName 님! (copyright $currentYear)"
    }
    println(greetingFunction3("chad", 2))
}


private fun chapter4(){

    val name ="마드리갈"
    val healthPoint = 89
    var isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoint, isImmortal)
    val healthStatus = formatHealthStatus(healthPoint, isBlessed)

    //플레이어의 상태 출력
    printPlayerStatus(auraColor,isBlessed,name,healthStatus)

    // 유닛함수 p 66
    // 아무값도 반환하지 않는 함수를 나타내기 위해 사용되는 반환 타입 unit
    // 리턴 타입이 없으면 제네릭을 처리하기 힘들다.
    // ctrl + shift + p
    castFireball()
}
// 단일 표현식 p 65
private fun formatHealthStatus(healthPoint:Int,isBlessed:Boolean) :String =
    when (healthPoint){
        100 -> "최상의 상태"
        in 90..99 -> "약간의 찰과상이 있음"
        in 75..89 -> if (isBlessed){
            "경미한 상처만 있음."
        }else{
            "경미한 상처만있음."
        }
        in 15..74->"많이 다친 것 같음"
        else -> "최악의 상태임!"
    }

private fun printPlayerStatus(auraColor:String, isBlessed: Boolean, name:String,healthStatus:String){
    println("(Aura:$auraColor)" + "(Blessed : ${if (isBlessed)"YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed:Boolean, healthPoint: Int,isImmortal:Boolean):String{
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if(auraVisible) "GREEN" else "NONE"
    return auraColor
}

// 단일 표현식 p 65
// 기본인자 p63
private fun castFireball(numFireball:Int = 2) =
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireball)")


