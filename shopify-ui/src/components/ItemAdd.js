import React from 'react';
import { Container, Card, ButtonGroup,Form,Button, FormControl,Row, Col } from 'react-bootstrap';
import axios from 'axios';
import urls from "./utils"
import ItemImage from './ItemImage';

class ItemAdd extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            itemName:'',
            itemCategory:'',
            itemPrice:'',
            totalPrice:'',
            itemQuantity:'',
            itemRemaining:'',
            supplierId:'',
            arrivalTime:'',
            updatedTime:'',
            itemURL:'',
            selectedFile: null,
            selectedFiletoDisplay: null,
            showPreview:false
        }
      }
    
      onFileChange = event => {
        this.setState({
            selectedFiletoDisplay: URL.createObjectURL(event.target.files[0]), 
            selectedFile: event.target.files[0],
            showPreview: true
         });
      };

    handleItemNameChange = (e) => {
        this.setState({ itemName: e.target.value });
    }
    handleItemCategoryChange = (e) => {
        this.setState({ itemCategory: e.target.value });
    }
    handleItemPriceChange = (e) => {
        this.setState({ itemPrice: e.target.value });
    }
    handleTotalPriceChange = (e) => {
        this.setState({ totalPrice: e.target.value });
    }
    handleItemQuantityChange = (e) => {
        this.setState({ itemQuantity: e.target.value });
    }
    handleItemRemainingChange = (e) => {
        this.setState({ itemRemaining: e.target.value });
    }
    handleSupplierChange = (e) => {
        this.setState({ supplierId: e.target.value });
    }

    addItem=(event)=>{
        event.preventDefault();

        if(this.state.itemName==null || this.state.itemName==''){
            return alert("Please Enter Item Name")
        }

        if(this.state.itemCategory==null || this.state.itemCategory==''){
            return alert("Please Enter Item Category")
        }

        if(this.state.itemPrice==null || this.state.itemPrice==''){
            return alert("Please Enter Price of each item")
        }
        if(this.state.totalPrice==null || this.state.totalPrice==''){
            return alert("Please Enter Total Price")
        }
        if(this.state.itemQuantity==null || this.state.itemQuantity==''){
            return alert("Please Enter Quantity")
        }
        if(this.state.itemRemaining==null || this.state.itemRemaining==''){
            return alert("Please Enter Quantity Remaining")
        }
        if(this.state.supplierId==null || this.state.supplierId==''){
            return alert("Please Enter Supplier ID")
        }
        if(this.state.selectedFile==null){
            return alert("Please Upload an image")
        }

        const formData = new FormData();

        formData.append("file", this.state.selectedFile);
        axios.post(urls.backendURL+'/shopify/item/uploadImage', formData, {
             headers: {
               'Content-Type': 'multipart/form-data'
             }
                }).then(response => response.data).then((data) => {
                    console.log(data)
                });
        
        const postData = {
            itemName: this.state.itemName,
            itemCategory: this.state.itemCategory,
            itemPrice: this.state.itemPrice,
            totalPrice: this.state.totalPrice,
            itemQuantity: this.state.itemQuantity,
            itemRemaining: this.state.itemRemaining,
            supplierId: this.state.supplierId,
            itemURL:urls.cloudfront+this.state.selectedFile.name
        }
          axios.post(urls.backendURL+'/shopify/item/add', postData).then(response => response.data)
          .then((data) => {
            console.log(data)
          });

          alert("Successfully Added!!")
     }


     render() {

        return (
                <Container fluid>

                    <Row>
                    <Col>
                    <Card style={{ width: '60rem' }}><Card.Body> 
                        <div class="col d-flex justify-content-center">
                        <form onSubmit={this.addItem}>
                                <Form.Group as={Row} className="mb-5" controlId="1">
                                    <Form.Label column sm="6"><div><h5>Add Item to Inventory</h5></div></Form.Label>
                                    <Form.Control type="text" placeholder="Item Name" value={this.state.itemName} onChange={this.handleItemNameChange}/>
                                    <Form.Control type="text" placeholder="Item Category" value={this.state.itemCategory} onChange={this.handleItemCategoryChange}/>
                                    <Form.Control type="text" placeholder="Item Price" value={this.state.itemPrice} onChange={this.handleItemPriceChange}/>
                                    <Form.Control type="text" placeholder="Total Price" value={this.state.totalPrice} onChange={this.handleTotalPriceChange}/>
                                    <Form.Control type="text" placeholder="Quantity on Arrival" value={this.state.itemQuantity} onChange={this.handleItemQuantityChange}/>
                                    <Form.Control type="text" placeholder="Quantity Remaining" value={this.state.itemRemaining} onChange={this.handleItemRemainingChange}/>
                                    <Form.Control type="text" placeholder="Supplier ID" value={this.state.supplierId} onChange={this.handleSupplierChange}/>
                                    <Form.Control type="file"  onChange={this.onFileChange}/>
                                </Form.Group>
                                {this.state.showPreview===true?(
                                <h4>Please scroll down to see Preview</h4>
                                ):(<div></div>)}
                                <Button type="submit" variant="dark" size="md" active>ADD</Button>
                                
                            </form>
                            </div>
                    </Card.Body></Card>
                    </Col>
                    <Col>
                        {this.state.showPreview===true?(
                            //  (<img className="resize" src={this.state.selectedFiletoDisplay}/>)
                            (<ItemImage imageProp={this.state.selectedFiletoDisplay}></ItemImage>)
                        ):(<div></div>)}
                    </Col>
                    </Row>
                </Container>
                )
    }
}

export default ItemAdd;
