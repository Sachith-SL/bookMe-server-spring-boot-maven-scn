# POC : Spring Boot + Maven

### Database Tables

#### Table 01: Reservation
- **Columns:**
    - `id`: Long (`PK`)
    - `user`: Reference to `User`
    - `date`: Date
    - `amount`: Double
    - `status`: Enum (`PENDING`, `CONFIRMED`, `IN_PROGRESS`, `COMPLETED`)

#### Table 02: Slot
- **Columns:**
    - `id`: Long (`PK`)
    - `date`: Date
    - `startTime`: Time
    - `endTime`: Time
    - `unitPrice`: Double
    - `isAvailable`: Boolean

#### Table 03: ReservationSlot
- **Columns:**
  - `id`: Long (`PK`)
  - `reservation_id`: Long (`FK`)
  - `slot_id`: Long (`FK`)

#### Table 04: User
- **Columns:**
    - `id`: Long (Primary Key)
    - `name`: String
    - `mobile`: String
    - `role`: Enum (`ADMIN`, `CUSTOMER`)

#### Table 05: Transaction
- **Columns:**
  - `id`: Long (Primary Key)
  - `reservation`; Reference to `Reservation`
  - `date`: LocalDate;
  - `paymentMethod`: String;
  - `amount`: Integer;
  - `status`: Enum (`PENDING`, `COMPLETED`) ;

### Enums

- **Reservation Status:**
    - `PENDING`
    - `CONFIRMED`
    - `IN_PROGRESS`
    - `COMPLETED`

- **User Role:**
    - `ADMIN`
    - `CUSTOMER`
