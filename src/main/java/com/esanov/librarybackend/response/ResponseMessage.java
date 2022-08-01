package com.esanov.librarybackend.response;

public class ResponseMessage {

   private String str;

   public ResponseMessage() {
   }

   public ResponseMessage(String str) {
      this.str = str;
   }

   public void setStr(String str) {
      this.str = str;
   }

   public String getStr() {
      return str;
   }
}
