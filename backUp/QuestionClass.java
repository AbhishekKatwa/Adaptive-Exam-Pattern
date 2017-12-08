public class QuestionClass
{
  int questionID;
  String question;
  String optionA;
  String optionB;
  String optionC;
  String optionD;
  String correctoption;
  QuestionClass(int questionID,String question,String optionA,String optionB,String optionC,String optionD,String correctoption)
  {
    this.questionID=questionID;
    this.question=question;
    this.optionA=optionA;
    this.optionB=optionB;
    this.optionC=optionC;
    this.optionD=optionD;
    this.correctoption=correctoption;
  }
}