package br.com.hugoogle.enumerator;

public enum ColorEnum {
   YELLOW("\u001B[33m"), RED("\u001B[31m"), GREEN("\u001B[32m"), BLUE("\u001B[34m"), RESET("\u001B[0m");

   final String colorCode;

   ColorEnum(String colorCode) {
      this.colorCode = colorCode;
   }

   public String getColorCode() {
      return this.colorCode;
   }

}
