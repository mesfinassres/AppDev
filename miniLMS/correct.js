//----------------------------- Exam correction script ----------------------------------------
	
//		Designed for the Course Information technolofgy for grade 11

//---------------------------------------------------------------------------------------------


function results() {
	var aquest      = new Array;
 	var all 	= document.quiz.elements.length;
	var questions 	= 1.0 * document.quiz.qnum.value;
	var num_skipped = 0;
	var num_correct = 0;
        var answers     = document.quiz.anum.value;
        
        
        //-----------reslove answers -------------------------------
         for ( i = 0; i < questions; i++) {
            if (answers.substring(i,i+1)=="A") aquest[i]=1;
            else if (answers.substring(i,i+1)=="B") aquest[i]=2;
            else if (answers.substring(i,i+1)=="C") aquest[i]=3;
            else if (answers.substring(i,i+1)=="D") aquest[i]=4;
          }
  

	// --------run through all questions------------------------
	for (q = 1; q <= questions; q++) {

		var selected = false;
		var correct = false;
				
	       // for each question, we run through all radio buttons,that match current question 
	       for (i = 0; i < all; i++) {

			var e = document.quiz.elements[i];
			if (e.name == "q" + q) {

				// see if they clicked on anything
				if (e.checked) {
					selected = true;
					
					// see if the value is correct
					if (aquest[q - 1] == e.value) {
						correct = true;
			                        document.images['q' + q + 'r' + e.value].src = 							               "top_dir_files/ok.gif";
		    		        }
					else
					    document.images['q' + q + 'r' + e.value].src = 							"top_dir_files/wrong.gif";
				}
			}	
				
		  }//for(i)
		
                  if (!selected)
			   num_skipped += 1;
		  if (correct) {
			   num_correct += 1;
                  }
	   		
	 }//for(q)

	
         var percentscore= (num_correct/questions)*100;

         document.quiz.score.value=num_correct;

         
         //------------------write the results------------------------
   		
	 if((num_correct == questions) && (num_correct!=0)) {


              var result = "Congratulations!\nYou answered all questions correctly.";
                                                         
              document.quiz.remark.value="Excellent";

         }
         else if ((percentscore < 100) && (percentscore >= 75)) {


              result = "Very good!\nYou answered above 75% of the questions correctly.";
                                                         
              document.quiz.remark.value="Very good";
                
         } 

         else if ((percentscore < 75) && (percentscore >=50)) {


              result = "Good!\nYou answered above 50% of the questions correctly.";
                                                         
              document.quiz.remark.value="Good";
                
         } 

	 else 

         {	
              result = "Your results are: \n" + "Correct - " + num_correct + "\n" + 
			 "Incorrect - " + (questions - num_correct - num_skipped) + "\n" + 
                         "Skipped - " + num_skipped + "\n"; 	

              document.quiz.remark.value="Poor";		 
         }

		
         alert(result);


}//-----------------------------End of function results	-------------------------------------


function uncheck(){
	
	var all = document.quiz.elements.length;
	var questions 	= 1.0 * document.quiz.qnum.value;
	for (q = 1; q <= questions; q++) {
		for (i = 0; i < all; i++) {

			var e = document.quiz.elements[i];
			if (e.name == "q" + q)
			{    
				e.checked = false;
				document.images['q' + q + 'r' + e.value].src = 						                   "top_dir_files/blank.gif";
			}
		}
	}
}


//--------------------------------End of script ----------------------------------------------
