import { Component } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product.model';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent {

  product: Product = {
    name: '',
    price: ''
  }

  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute) {
    const id = this.route.snapshot.paramMap.get('id')
    if(id != null){
      this.productService.readById(id).subscribe(product => {
        this.product = product
      });
    }
  }

  updateProduct(): void {
    this.productService.updade(this.product).subscribe(() => {
      this.productService.showMessage('Produto atualizado')
    })
    this.router.navigate(['/products'])
  }

  cancel(): void {
    this.router.navigate(['/products'])
  }

}
