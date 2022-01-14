import React from 'react';
import { Container, Card, ButtonGroup,Form,Button, FormControl,Row, Col } from 'react-bootstrap';
import ItemAdd from './ItemAdd';
import ItemDelete from './ItemDelete';
import ItemUpdate from './ItemUpdate';
import ItemView from './ItemView';

class Home extends React.Component {

  constructor(props){
    super(props)
    this.state = {
        itemName:'',
        itemQuantity:'',
        supplierId:'', 
         showItemAddPage: false,
         showItemDelete: false,
         showItemUpdate: false,
         showItemViewPage: true,
    }
  }

  addItem=(event)=>{
    event.preventDefault();
        this.setState({
     
            showItemAddPage: true,
            showItemDelete: false,
            showItemUpdate: false,
            showItemViewPage: false,
            showExportDataPage: false
        })
    }
    deleteItem=(event)=>{
        event.preventDefault();
            this.setState({
         
                showItemAddPage: false,
                showItemDelete: true,
                showItemUpdate: false,
                showItemViewPage: false,
                showExportDataPage: false
        })
    }

    updateItem=(event)=>{
        event.preventDefault();
            this.setState({
         
                showItemAddPage: false,
                showItemDelete: false,
                showItemUpdate: true,
                showItemViewPage: false,
                showExportDataPage: false
            })
        }
        viewItem=(event)=>{
            event.preventDefault();
                this.setState({
             
                    showItemAddPage: false,
                    showItemDelete: false,
                    showItemUpdate: false,
                    showItemViewPage: true,
                    showExportDataPage: false
            })
        }

  
    render() {

    return (
        <Container fluid>
            <Row>
            <Card bg={'Dark'.toLowerCase()} text={'white'}>
              <Card.Body><Card.Body>
                <h3>Shopify Inventory Management</h3>
              </Card.Body></Card.Body>
            </Card>
            </Row>
            <Row>
            <Col>
            <div class="btn-group-vertical">
                &nbsp;
                <Button variant="dark" onClick={this.addItem}>Add Item</Button>
                &nbsp;
                <Button variant="dark" onClick={this.deleteItem}>Delete Item</Button>
                &nbsp;
                <Button variant="dark" onClick={this.updateItem}>Update Item</Button>
                &nbsp;
                <Button variant="dark" onClick={this.viewItem}>View Item</Button>
                &nbsp;
                
                </div>
            </Col>
            <Col>
                {this.state.showItemAddPage=== true? (<ItemAdd></ItemAdd>):(<div></div>)}
                {this.state.showItemDelete=== true? (<ItemDelete></ItemDelete>):(<div></div>)}
                {this.state.showItemUpdate=== true? (<ItemUpdate></ItemUpdate>):(<div></div>)}
                {this.state.showItemViewPage=== true? (<ItemView></ItemView>):(<div></div>)}      
          </Col>
          </Row>
        </Container>
    );
  }
}

export default Home;