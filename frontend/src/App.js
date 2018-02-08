import React, {Component} from 'react';
import logo from './Sutlej search logo.png';
import './App.css';

class App extends Component {
  constructor(){
    super();
    this.state = {
      dataValue: ""
    }
  }

  componentDidMount() {
    document.title = "Sutlej";

    var self = this;
    var dataUrl = 'http://localhost:8080/api/ping';
    fetch(dataUrl)
      .then(function (response) {
        if (response.status >= 400){
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(function (data) {
        self.setState({dataValue: data});
      });
  }

  render() {
    const petList = Object.entries(this.state.dataValue).map(([key,value])=>{
      return (
        <div>{key} : {value.toString()}</div>
      );
    });
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <h2>Welcome to Sutlej search engine!</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        <div>{petList}</div>
      </div>
    );
  }
}

export default App;
