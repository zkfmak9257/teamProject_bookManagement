package com.ohgiraffers.section01.list.dto;

import java.util.LinkedList;
import java.util.Queue;

public class BookDTO implements Comparable<BookDTO> {

  /* 도서 정보를 저장할 DTO 클래스를 만들어보자 */
  private int number;
  private String title;
  private String author;
  private String genre;
  private String publisher;
  private int year;
  private int price;
  private boolean isAvailable;
  private String condition;

  // 예약 FIFO방식
  private Queue<String> reservationQueue = new LinkedList<>();

  public BookDTO() {
  }

  public BookDTO(int number, String title, String author, String genre, String publisher,
                 int year, int price, boolean isAvailable, String condition) {
    this.number = number;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.year = year;
    this.price = price;
    this.isAvailable = isAvailable;
    this.condition = condition;
  }

  /* 객체 복사 생성자 */
  public BookDTO(BookDTO other) {
    this.number = other.number;
    this.title = other.title;
    this.author = other.author;
    this.genre = other.genre;
    this.publisher = other.publisher;
    this.year = other.year;
    this.price = other.price;
    this.isAvailable = other.isAvailable;
    this.condition = other.condition;

    // 예약 큐 깊은 복사
    this.reservationQueue = new LinkedList<>(other.reservationQueue);
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  @Override
  public String toString() {
    return "BookDTO{" +
        "number=" + number +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", genre='" + genre + '\'' +
        ", publisher='" + publisher + '\'' +
        ", year=" + year +
        ", price=" + price +
        ", isAvailable=" + isAvailable +
        ", condition='" + condition + '\'' +
        ", reservationCount=" + reservationQueue.size() +
        '}';
  }


  /* Comparable<T> 인터페이스
   * - 같은 인스턴스 끼리의 기본 비교 방법을 정의하는
   *   compareTo() 메서드 제공 인터페이스
   * */
  @Override
  public int compareTo(BookDTO o) {
    // 가격 순서
    // return this.price - o.price;

    // 이름 순서 (String의 compareTo() 활용)
    return this.title.compareTo(o.title);

  }

  /**
   * 예약 신청 (대기열 맨 뒤에 추가)
   *
   * @param user 예약자 이름 또는 아이디
   * @return true면 성공, false면 실패
   */
  public boolean addReservation(String user) {
    if (user == null || user.isEmpty()) return false;
    return reservationQueue.offer(user);
  }

  /**
   * 다음 순번 예약자를 반환해주고 대기열에서 제거한다.
   *
   * @return 다음 예약자 이름(아이디), 없으면 null
   */
  public String pollNextReservation() {
    return reservationQueue.poll();
  }
  /**
   * 다음 순번 예약자 미리 보기
   */
  public String peekNextReservation() {
    return reservationQueue.peek();
  }
  /**
   * 현재 대기 인원수
   */
  public int getReservationCount() {
    return reservationQueue.size();
  }
  /**
   * 예약 대기열이 비어있는지 여부
   */
  public boolean hasReservations() {
    return !reservationQueue.isEmpty();

  }


}