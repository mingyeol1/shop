스프링부트는 서버를 만드는 프레임워크임.
= 즉 서버를 만드는 뻐대가 있는 프로그램임.

프레임 워크란? 일정한 틀이 있는 뼈대를 말한다.(프로그램에서)
= 프로그램을 개발하기 위해 사용되는 틀을 제공하는 프로그램

@ResponseBody란?
스프링에서 HTTP 요청에 대한 응답을 JSON 또는 XML 같은 데이터 형식으로 직접 반환하는 데 사용되는 애노테이션입니다.
-> 컨트롤러에서 사용시 문자 그대로를 return 을 하는거임 url주소로 입력할시 빼야함



서버 개발이란?
유저가 A를 달라고 하면 A를 보내주는 코드를 만드는 것

웹서버란?
웹 페이지를 달라고 하면 웹 페이지를 보내주는 것
ex 메인 페이지를 보여달라 하면 보여주는것. 로그인을 요청하면 로그인을 보내주는 것



왜? 메인 함수안에 코드 안넣어도 실행이 가능함?
-> 스프링 프레임워크 때문에 가능.
@어노테이션을 붙이면 Spring이 알아서 처리해줌 (메인함수에 넣어줌.)

class 앞에 보통 public이 붙는데 없으면 같은 패키지폴더 안에서만 사용이 가능함.
pubilc이 있으면 다른 패키지폴더 에서도 사용이 가능함.


템플릿엔진이란? 서버 및 데이터베이스의 데이터를 HTML에 집어(주입)넣을 수 있음.
보통 Thymeleaf를 사용함 // SSR(서버사이드 랜더링.)



3 step
HTML에 서버데이터를 넣어서 보내주려면
템플릿 엔진을 다운.
2. Controller에 Model 파라미터를 추가.
3. model.addAttribute("작명", 데이터)를 써서
   4.th:=text="${작명}"을 써서 보내줄 수 있음.

여러 데이터를 보내고 싶으면
model.addAttribute("작명1", 데이터)
model.addAttribute("작명2", 데이터)
를 써도 상관 없음.


내가 쓰는 MySQL 데이터 베이스는 관계형 데이터 베이스임
관계형 데이터 베이스란 ? 표형태로 데이터 베이스를 저장함.


*** 라이브러리를 사용할 시 이걸 왜 사용하는지 꼭 알고 쓰자. ***


롬복(LomBok)이란??
내가 사용하는 곳은 스프링 프레임워크인데 여기서 코드를 좀 더 간결하게 쓸 수 있도록 도와주는 라이브러리임
ex) 게터세터 생성자를 자동으로 생성해줌.(어노테이션 붙어야함.)
이걸 왜 사용하냐? 코드가 짧아져서 생산성이 높아짐.


AJAX는 return시 리다이렉트가 잘 되지 않으므로 ResponseEntity로 바꾼 후 리턴 타입도 바꿔주면 됨.
fecth 후 .then()을 붙이면 실행 후 나중에 실행할 것을 또 만들 수 있음.(AJAX요청 후 코드 실행 할 수 있도록)
그리고 then을 2개 붙여줘야함


@Bean 이란?
스프링이 뽑아주는 오브젝트.

dependency injection(의존성 주입) : DI

interface : 함수 정의만 넣는 class라고 생긱하면 편함 다른 클래스가 이걸 사용하고 싶을 때 함수를 만들도록 강요함.


Controller에서 유저 권한을 뽑으려면 (UserDetailService를 만들었다는 가정하)
한 메서드를 만든 후
매개변수에 Autehntication < 함수를 받아오고
System.out.println(Autehntication) << Autehntication 객체 출력
System.out.println(Autehntication.getName()) << 사용자 이름을 불러오는 메서드
System.out.println(Autehntication.getAuthorities()) << 사용자의 권한을 불러오는 메서드 를 입력해주면 됨.

Autehntication인터페이스는 스프링시큐리티의 핵심 인터페이스로 다양한 인증 정보를 재공함.

Principal을 사용할 수도 있지만 이건 현재 로그인한 사용자의 이름만 필요할 때 사용을 함


html 타임리프문법
<div sec:authorze="isAuthenticated()"></div>	//로그인 한 사람만 html 을 보여줌
<div sec:authorze="isAnonymous()"></div>	//로그인 안한 사람만 html 을 보여줌



DTO를 사용하는이유
1. 타입추론이 쉽고 어떤 객체를 사용할 수 있는지 알기 쉬움
2. 재사용이 쉬움 나중에 필요한 값이 있으면 추가만해주면 됨.




html
<input type="file" onchange="fetch()'>	유저가 file을 넣으면 onchange가 실행됨.(서버에 요청을 날림.)

Presigned URL란? : 유저가 직접 S3에 업로드하는 방식.

이미지를 저장(업로드)할 때  Presigned URL 를 사용하는 이유는 서버에 안거치고 바로 S3로 가서 서버에 부담이 좀 사라진다.
유저가 이미지를 다룰 때 렘이 부족할 수 있는 상황을 막아 줄 수 있음(서버에 부담이 덜함)

단점 : 유저가 이상한 이미지를 업로드하는걸 막기가 힘듦 / 이미지 사이즈를 줄이려면 자바스크립트 문법을 사용할 수도 있음.

정규화란?

별도의 테이블과 행으로 빼는 것? (3장 댓글기능1 보기.)


@ManyToOne 장단점.

장점

단점

select 쿼리문이 많이 실행될 수 있음.(DB에 많은 영향을 줌 N+1 문제 발생.)
해결방법 : Join문법으로 해결가능.

select * from shopdb.sales inner join shopdb.`member`
on sales.member_id = `member`.id;

MySQL 워크벤치에서 저렇게 타이핑 후 실행하면 sales + member를 합쳐서 출력해줌 (중복되는게 있으면.)
Repository에서도 가능.  SQL로 안되면 JQPL문법으로 짜야함.

@ManyToOne 등을 쓰다보면 성능문제가 발생할 수 있음
- 그때마다 직접 SQL / JPQL을 짜야함 이건 어쩔 수 없음.

단점 2.
모든 컬럼을 다 가져옴.(가져오지 말아야할 부분도 가져옴.)
그래서 object를 변환해서 DTO로 보내야함.









