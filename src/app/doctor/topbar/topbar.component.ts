import { Component } from '@angular/core';
import { faUser} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent {
  constructor() { }

  ngOnInit(): void {
  }

  faUser =faUser;
}
