import { ActivatedRoute, Router } from '@angular/router';
import { Component } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})

export class ProductDeleteComponent {
  
product: Product = {
  name: '',
  price: ''
}

  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute) {
    const id = this.route.snapshot.paramMap.get('id')
  if(id != null){
    this.productService.readById(id).subscribe(product => {
      this.product = product
    })
  }
  }


deleteProduct(): void {
  if(this.product.id != null){
    this.productService.delete(this.product.id).subscribe(() => {
      this.router.navigate(['/products'])
      this.productService.showMessage('Produto deletado')
    })
  }
}

cancel(): void {
  this.router.navigate(['/products'])
}

}
