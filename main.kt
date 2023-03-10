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
}
