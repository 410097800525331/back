import './css/reset.css'
import './css/BoxOfficeCard.css'
import poster from './img/YiSbqEf6OvFcDoLoQCipDojOHqMCwKG4_420.jpg'
import MX4D from './img/type_mega_mx4d.png'
import Cinema from './img/type_dolbycinema.png'
import Atmos from './img/type_dolbyatmos.png'
import ageAll from './img/ALL_56x56.png'

function BoxOfficeCard() {
  // props

  return (
    <div className="box_office_card">
      <div className="inner">
        <div className="front">
          <span className="rank">1</span>
          <div className="poster">
            <img src={poster} alt="주토피아" />
          </div>
          <div className="screen_type">
            <img src={MX4D} alt="Mega MX4D" />
            <img src={Cinema} alt="Dolby Cinema" />
            <img src={Atmos} alt="Dolby Atmos" />
          </div>
          <div className="grade">
            <img src={ageAll} alt="Movie Grade All" />
          </div>
        </div>
        <div className="back">
          <p>더 화려해진 세계, 더 넓어진 주토피아!<br />디즈니의 가~~장 사랑스러운 콤비 '주디'와 '닉'이 돌아온다!<br /><br />미스터리한 뱀 '게리'가 나타난 순간.</p>
          <div className="score">관람평<span>9.3</span></div>
        </div>
      </div>
      <div className="btn">
        <button type="button" className="like">
          <i className="fa-solid fa-heart"></i>3.6k
        </button>
        <a href="https://www.megabox.co.kr/booking" className="reservation_link">예매</a>
      </div>
    </div>
  );
}

export default BoxOfficeCard;
