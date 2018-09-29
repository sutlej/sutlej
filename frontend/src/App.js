import React, {Component} from 'react';
import logo from './sutlej.png';
import './App.css';

import SearchBar from 'react-search-bar'

class App extends Component {
  constructor() {
    super();
    this.state = {
      dataValue: ""
    }
  }

  componentDidMount() {
    document.title = "Sutlej";

    let self = this;
    let dataUrl = 'http://localhost:8080/api/put';
    fetch(dataUrl, {
      method: 'POST',
      body: '/home/manparvesh/Desktop/github_repos/sutlej/files'
    })
      .then(function (response) {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(function (data) {
        self.setState({dataValue: data});
      });
  }

  render() {
    const petList = Object.entries(this.state.dataValue).map(([key, value]) => {
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
        <SearchBar
          onChange={() => console.log('onChange')}
          onSearch={() => console.log('onRequestSearch')}
          renderSearchButton={true}
          renderClearButton={true}
          suggestions={["abcd", "asdadas", "sfdsa", "wewew"]}
          onClear={() => {
            console.log('onClear');
            this.state.value = "";
          }
          }
        />
      </div>
    );
  }
}

export default App;
