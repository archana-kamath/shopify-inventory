import React from 'react';
import { DropdownButton,Container, Card, ButtonGroup,Form,Button, Dropdown,Row, Col } from 'react-bootstrap';
import axios from 'axios';
import urls from "./utils"

class ItemImage extends React.Component {

    constructor(props){
        super(props)
        this.state={
            selectedFiletoDisplay:null
        }
      }

    componentDidMount(props){
        this.setState({ 
            selectedFiletoDisplay: this.props.imageProp
        });
    }

     render() {

        return (
                <Container fluid>
                    <img className="resize" src={this.state.selectedFiletoDisplay}/>
                </Container>
                )
    }

}

export default ItemImage;
