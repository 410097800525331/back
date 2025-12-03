// import './App.css'
// import { useState } from "react";

function Header(props) {
  console.log('props', props.title);
  return(
      <header>
        <h1><a href="/" onClick={function(e){
          e.preventDefault(); /* 기본 이벤트 방지 */
          props.onChangMode();
        }}>{props.title}</a></h1>
      </header>
  );
}
function Nav(props) {
  // const lis = [
  //   <li><a href="/read/1">html</a></li>,
  //   <li><a href="/read/2">css</a></li>,
  //   <li><a href="/read/3">js</a></li>
  // ];
  const lis = [];
  for (let i = 0; i < props.topice.length; i++) {
    let t = props.topice[i];
    lis.push(<li key={t.id}><a id={t.id} href={"/read/"+t.id} onClick={e=>{
      e.preventDefault();
      props.onChangMode(e.target.id);
    }}>{t.title}</a></li>);
  };

  return(
      <nav>
        <ol>
          {lis}
        </ol>
      </nav>
  );
}
function Article(props) {
  return(
      <article>
        <h2>{props.title}</h2>
        {props.body}
      </article>
  );
}

function Create() {
  return(
    <article>
      <h2>Create</h2>
      <form>
        <p><input type="text" name="title" placeholder="title" /></p>
        <p><input type="text" name="title" placeholder="title" /></p>
        <p><input type="text" name="title" placeholder="title" /></p>
      </form>
    </article>
  )
}

function App() {
  // const _mode = useState('WELCOME');
  const topice = [
    {id: 1, title: 'html', body: 'html is ...'},
    {id: 2, title: 'css', body: 'css is ...'},
    {id: 3, title: 'javascript', body: 'javascript is ...'}
  ];

  // let content = null;
  // CRUD(Create Read Update Delete)
  // if(mode === 'WELCOME') {
  //   content = <Article title="Welcome" body="Hello, Web" />
  // } else if(mode === 'READ') {
  //   content = <Article title="Welcome" body="Hello, Read" />
  // };

  return (
    <div>
      {/* 헤더 */}
      <Header title="WEB " onChangMode={()=>alert('Header')} />
      {/* 내비게이션 */}
      <Nav topice={topice} onChangMode={(id)=>{
        alert('id');
      }} />
      {/* 아티클 */}
    </div>
  )
}

export default App
