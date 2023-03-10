/*Second first */

class CountCalorie(val calories: Array<Int>) {
    val maxNumber = calories.max()

}


/*Second challenge */

enum class MySharp(val id: Int){
    Y(1),
    X(2),
    Z(3)
    
}

enum class OpponentSharp(val id: Int){
    A(1),
    B(2),
    C(3)
}


class Play(private val me:MySharp, private val opponent: OpponentSharp ) {
    
     var opponentScor = opponent.id 
    
     var myScor = me.id
    
    
    
    fun calculateWinner():String {

        if(opponentScor > myScor) {
            
            opponentScor = opponentScor + 6
            
           return "the winner is oppenent by $opponentScor"
          
        } else if(opponentScor < myScor) {
            
            myScor = myScor + 6
            
            return "you winner  by $myScor"
            
        } else {
            return "there are any winner the scorre go to Draw"
        }
         
    }
    
        fun getOppenentScor(): Int {
            
            if(opponentScor > myScor){
                return opponentScor + 6
            } else {
                return opponentScor
            } 
      }
        
       fun getMeScor(): Int {
            
            if(opponentScor < myScor){
                return myScor + 6
            } else {
                return myScor
            } 
      }
    
    
}

val lowerCaseAlphabeticMap = mapOf(
                "a" to 1, 
                "b" to 2,
                "c" to 3,
                "d" to 4,
                "e" to 5, 
                "f" to 6,
                "g" to 7,
                "h" to 8,
                "i" to 9, 
                "j" to 10,
                "k" to 11,
                "l" to 12,
                "m" to 13, 
                "n" to 14,
                "o" to 15,
                "p" to 16,
                "q" to 17, 
                "r" to 18,
                "s" to 19,
                "t" to 20,
                "u" to 21, 
                "v" to 22,
                "w" to 23,
                "x" to 24,
               "y" to 25,
               "z" to 26,
                
               )

val upperCaseAlphabeticMap = mapOf(
                "a" to 27, 
                "b" to 28,
                "c" to 29,
                "d" to 30,
                "e" to 31, 
                "f" to 32,
                "g" to 33,
                "h" to 34,
                "i" to 35, 
                "j" to 36,
                "k" to 37,
                "l" to 38,
                "m" to 39, 
                "n" to 40,
                "o" to 41,
                "p" to 42,
                "q" to 43, 
                "r" to 44,
                "s" to 45,
                "t" to 46,
                "u" to 47, 
                "v" to 48,
                "w" to 49,
                "x" to 50,
                 "y" to 51,
                "z" to 52,
                
               )


class CharacterToArrange(private val contentRucksacks: Array<String>) {
    
     private  fun getFirstPartOfString( stringCharatere: String): String{
        return stringCharatere.substring(0, stringCharatere.length/2)
        }
    
    private  fun getScondPartOfString(stringCharatere: String): String {
        
        return stringCharatere.substring(stringCharatere.length/2, stringCharatere.length)
        
       }
    
    
    private fun findSimilareElement( element: String): Int{
        val firstElement = getFirstPartOfString(element)
        
        val secondCharacter = getScondPartOfString(element)
        
        
        var priority:Int = 0
        
        
        firstElement.forEach({ 
       if( secondCharacter.contains(it)) {
          
          priority = gerPriority(it.toString())
       
       }
    })
        
        return priority
        
    }
    
      
  
    
private fun gerPriority(letter: String): Int {
    
    if(letter.toCharArray()[0].isUpperCase()) {
      
        return upperCaseAlphabeticMap[letter.lowercase()]?: 0
    } else {
      
        return lowerCaseAlphabeticMap[letter]?: 0
    }
   
}

 fun getPrioritySum(): Int{
       
       var sumV = 0
       
       contentRucksacks.forEach({
          sumV = sumV + findSimilareElement(it)
       })
       
      // println("sumV $sumV")
       
       return sumV
   }
     
    
}


    
    class AvenceOfCodeDay4(val list: List<String>) {
        
        
        
        private fun getFullRange(value: String):String {
           val firstValue = value.split("-")[0].toInt()
           val secondValue = value.split("-")[1].toInt()
           
           var concat = ""
           
           for(i in firstValue..secondValue){
               val convertedValue = i.toString()
                concat = concat + convertedValue
              
           }
           
           return concat 
       }
         
      
   
   private fun listOfPair(): MutableList<String> {
       val rangeList: MutableList<String> = mutableListOf()
       list.forEach{rangeList.add(getFullRange(it))}
       println(rangeList)
       return rangeList 
   }
   
  
   
   
   private fun getPairToCompar(): List<Int> {
        val numberItaration = List<Int>(listOfPair().size/2){0}
        
        return numberItaration
       
   }
   
   fun getNumberFullContain(): Int {
       
       var fulContain = 0
     var mutablePairList = listOfPair()
       
       getPairToCompar().forEach{
          
          
           fulContain += comparePair(mutablePairList.removeAt(0), mutablePairList.removeAt(0))
           
           println(fulContain)
       }
       
       return fulContain
   }
   
   private fun comparePair(pair1: String, pair2: String): Int {
       // println("$pair1 $pair2")
       var fullContain = 0
       if(pair1.length == 1) {
           
          var last =  pair2.last()
          val last1 = last.toString().toInt()
          val firtValue = pair1.toInt()
          println("$last1" + " primoCaso " + "$firtValue")
          if(last1 == firtValue) {
              fullContain = 1
          }
          
          return fullContain
           
       } else {
           val firstOfFirstPay1 = pair1.first().code
           val secondOfFirstPay1 = pair1.last().code
           
           val firstOfSecodPay2 = pair2.first().code
           val secondOfSceondPay2 = pair2.last().code
           
           if(firstOfFirstPay1< firstOfSecodPay2 && secondOfFirstPay1>  secondOfSceondPay2) {
              // println("secondCaso")
               fullContain = 1
           } 
           
           return fullContain
          
       }
   }
        
}



fun main() {


     val items = arrayOf(1, 2, 3, 4, 5)
    

    
    println(CountCalorie(items).maxNumber)

     

    
    var opponentScor = 0
    
    var myScor = 0
    
       fun finalWinner(opponentScor: Int, myScor: Int): String {
        
        return when{
            opponentScor > myScor -> " the final winner is Opponnet winner by $opponentScor"
            
            opponentScor< myScor ->"the final winner is you  by $myScor"
            
            else -> "final there any winner"
            
        }
        
    }
    

    
    
   /*  println(Play(MySharp.X, OpponentSharp.A).calculateWinner())
     
    
   opponentScor = opponentScor + Play(MySharp.X, OpponentSharp.A).opponentScor
    
    myScor      =      myScor + Play(MySharp.X, OpponentSharp.A).myScor
    
    println("first call $opponentScor, $myScor")*/
    
   
    
    
  /*  println(Play(MySharp.Z, OpponentSharp.A).calculateWinner())
    
    opponentScor = opponentScor + Play(MySharp.Z, OpponentSharp.A).opponentScor
    
    myScor = myScor + Play(MySharp.X, OpponentSharp.A).myScor*/
    
  
    
    println(Play(MySharp.X, OpponentSharp.B).calculateWinner())
    
    opponentScor = opponentScor + Play(MySharp.X, OpponentSharp.B).getOppenentScor()
    
    myScor = myScor + Play(MySharp.X, OpponentSharp.B).getMeScor()
    
    println("second call $opponentScor, $myScor")
    
    
     println(Play(MySharp.Y, OpponentSharp.B).calculateWinner())
     

   
     
    opponentScor = opponentScor + Play(MySharp.Y, OpponentSharp.B).getOppenentScor()
    
    myScor = myScor + Play(MySharp.Y, OpponentSharp.B).getMeScor()
    
    println("third call $opponentScor, $myScor")
    
   
    println(finalWinner(opponentScor, myScor))
    
     println( CharacterToArrange(arrayOf(
       "vJrwpWtwJgWrhcsFMMfFFhFp",
       "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
       "PmmdzqPrVvPwwTWBwg",
      "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
      "ttgJtRGJQctTZtZT",
     "CrZsJsPPZsGzwwsLwLmpwMDw"
   
   )).getPrioritySum())


   val listNumber = listOf("2-4","6-8", "2-3", "4-5", "5-7","7-9", "2-8","3-7", "6-6","4-6", "2-6","4-8")

   println(AvenceOfCodeDay4(listNumber).getNumberFullContain())
}
