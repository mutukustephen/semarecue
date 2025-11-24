# MOJAVE WILD - UI/UX Design Specification

## Design Theme

### Color Palette

**Primary Colors:**
- **Safari Gold**: `#D4AF37` - Headers, highlights, important buttons
- **Savanna Green**: `#4A7C59` - Primary buttons, active states
- **Earth Brown**: `#8B4513` - Secondary elements, borders

**Secondary Colors:**
- **Sky Blue**: `#87CEEB` - Day time UI elements
- **Sunset Orange**: `#FF6B35` - Alerts, fire-related UI
- **Night Purple**: `#4A148C` - Night mode UI tint

**Neutral Colors:**
- **Cream**: `#F5F5DC` - Background, text areas
- **Dark Brown**: `#3E2723` - Text, icons
- **Light Tan**: `#D2B48C` - Card backgrounds

### Typography

**Headers**: Bold, sans-serif (e.g., "Bebas Neue", "Oswald")
**Body Text**: Clean, readable sans-serif (e.g., "Roboto", "Open Sans")
**Accent**: Handwritten style for special elements (e.g., "Kalam")

### Visual Style

- **African Patterns**: Subtle geometric tribal patterns in borders and backgrounds
- **Natural Textures**: Wood grain, leather, canvas textures for UI elements
- **Animal Silhouettes**: Used as decorative elements and icons
- **Organic Shapes**: Rounded corners, flowing lines

## Screen Designs

### 1. Splash Screen

**Layout:**
```
┌─────────────────────────┐
│                         │
│    [Game Logo Large]    │
│   MOJAVE WILD          │
│                         │
│   [Animal Silhouettes]  │
│                         │
│   [Loading Bar]         │
│   "Loading..."          │
│                         │
└─────────────────────────┘
```

**Elements:**
- Large game logo with African sunset background
- Silhouettes of elephant, lion, giraffe
- Animated loading bar with safari gold color
- Fade-in animation (2 seconds)

### 2. Main Menu

**Layout:**
```
┌─────────────────────────┐
│   [MOJAVE WILD Logo]    │
│   Wildlife Ranger       │
├─────────────────────────┤
│                         │
│   [NEW GAME Button]     │
│   [CONTINUE Button]     │
│   [ENCYCLOPEDIA]        │
│   [SETTINGS]            │
│   [EXIT]                │
│                         │
│   [African Pattern]     │
└─────────────────────────┘
```

**Button Style:**
- Wooden texture background
- Gold borders when selected
- Subtle shadow for depth
- Icon on left, text centered
- Tap animation: scale down slightly

**Background:**
- Blurred savanna landscape
- Animated grass swaying
- Parallax effect on scroll

### 3. Game HUD (Heads-Up Display)

**Layout:**
```
┌─────────────────────────┐
│ [HP] [Stamina] [Time]   │
│ ┌─────────┐             │
│ │Mini-Map │  [Mission]  │
│ └─────────┘  Objective  │
│                         │
│        [Gameplay]       │
│                         │
│                         │
│ [Inventory]  [Interact] │
└─────────────────────────┘
```

**Top Bar:**
- Health bar (red/green gradient)
- Stamina bar (yellow/orange)
- Time of day indicator with sun/moon icon
- Semi-transparent background

**Mini-Map:**
- Top-left corner
- Circular design
- Shows player position, animals, objectives
- Tap to expand

**Mission Tracker:**
- Top-right corner
- Current objective text
- Progress bar
- Time remaining (if timed mission)

**Bottom Bar:**
- Quick inventory slots (4-5 items)
- Interact button (appears when near object)
- Virtual joystick (left side)
- Action buttons (right side)

### 4. Inventory Screen

**Layout:**
```
┌─────────────────────────┐
│   [← INVENTORY]         │
├─────────────────────────┤
│ ┌───┬───┬───┬───┬───┐  │
│ │ 1 │ 2 │ 3 │ 4 │ 5 │  │
│ ├───┼───┼───┼───┼───┤  │
│ │ 6 │ 7 │ 8 │ 9 │10 │  │
│ ├───┼───┼───┼───┼───┤  │
│ │11 │12 │13 │14 │15 │  │
│ └───┴───┴───┴───┴───┘  │
├─────────────────────────┤
│ [Item Details]          │
│ Name: Medical Kit       │
│ Quantity: 3             │
│ Description: ...        │
│ [USE] [DROP]            │
└─────────────────────────┘
```

**Grid Style:**
- 5x4 grid of item slots
- Empty slots show faded background
- Item icons with quantity badge
- Tap to select, shows details below
- Drag to reorder (optional)

**Item Details Panel:**
- Item name and icon
- Quantity
- Description
- Use/Drop buttons
- Stats/effects if applicable

### 5. Map View

**Layout:**
```
┌─────────────────────────┐
│   [← MAP]    [Legend]   │
├─────────────────────────┤
│                         │
│   [Top-Down Map View]   │
│                         │
│   • Player Position     │
│   🦁 Animal Locations   │
│   📍 Mission Markers    │
│   🏠 Ranger Base        │
│   💧 Water Sources      │
│                         │
│   [Zoom +/-]            │
└─────────────────────────┘
```

**Map Features:**
- Stylized top-down view
- Parchment/paper texture
- Discovered areas in color, undiscovered in sepia
- Pinch to zoom
- Drag to pan
- Icons for points of interest

**Legend:**
- Toggle button to show/hide
- Color-coded markers
- Distance indicators

### 6. Encyclopedia

**Layout:**
```
┌─────────────────────────┐
│   [← ENCYCLOPEDIA]      │
├─────────────────────────┤
│ [Search Bar]            │
├─────────────────────────┤
│ ┌─────────────────────┐ │
│ │ 🦒 Giraffe    [✓]  │ │
│ │ 🦓 Zebra      [✓]  │ │
│ │ 🦁 Lion       [✓]  │ │
│ │ 🐘 Elephant   [🔒] │ │
│ │ 🦏 Rhino      [🔒] │ │
│ └─────────────────────┘ │
├─────────────────────────┤
│ [Tabs]                  │
│ Wildlife | Skills |     │
│ Conservation | Items    │
└─────────────────────────┘
```

**Entry List:**
- Scrollable list of entries
- Unlocked entries in color with checkmark
- Locked entries grayed out with lock icon
- Tap to view full entry

**Entry Detail View:**
```
┌─────────────────────────┐
│   [← African Elephant]  │
├─────────────────────────┤
│   [Large Image/Icon]    │
│                         │
│   Scientific Name       │
│   Loxodonta africana    │
│                         │
│   [Tabs: Info | Facts | │
│    Conservation]        │
│                         │
│   [Content Area]        │
│   Scrollable text...    │
│                         │
└─────────────────────────┘
```

### 7. Mission Briefing

**Layout:**
```
┌─────────────────────────┐
│   [MISSION BRIEFING]    │
├─────────────────────────┤
│   [Mission Icon]        │
│                         │
│   Animal Rescue         │
│                         │
│   Description:          │
│   A distressed elephant │
│   has been spotted...   │
│                         │
│   Objectives:           │
│   • Locate animal       │
│   • Provide medical aid │
│   • Report status       │
│                         │
│   Reward: 150 XP        │
│   Time Limit: 10 min    │
│                         │
│   [ACCEPT] [DECLINE]    │
└─────────────────────────┘
```

**Style:**
- Parchment/paper background
- Mission type icon at top
- Clear objective list with checkboxes
- Reward and time info highlighted
- Large, clear action buttons

### 8. Mission Complete

**Layout:**
```
┌─────────────────────────┐
│   ★ MISSION COMPLETE ★  │
├─────────────────────────┤
│                         │
│   [Success Animation]   │
│                         │
│   Animal Rescued!       │
│                         │
│   Rewards:              │
│   • 150 XP              │
│   • Encyclopedia Entry  │
│                         │
│   [New Entry Unlocked]  │
│   African Elephant      │
│                         │
│   [CONTINUE]            │
└─────────────────────────┘
```

**Animation:**
- Star burst effect
- Confetti or sparkles
- XP counter animation
- Unlock notification

### 9. Settings

**Layout:**
```
┌─────────────────────────┐
│   [← SETTINGS]          │
├─────────────────────────┤
│                         │
│   Audio                 │
│   Master Volume  [====] │
│   Music         [====] │
│   SFX           [====] │
│                         │
│   Graphics              │
│   Quality       [Medium]│
│   FPS Limit     [30]    │
│                         │
│   Controls              │
│   Sensitivity   [====] │
│   Invert Y      [OFF]   │
│                         │
│   [SAVE] [RESET]        │
└─────────────────────────┘
```

**Controls:**
- Sliders for volume and sensitivity
- Dropdown for quality settings
- Toggle switches for boolean options
- Save/Reset buttons at bottom

## UI Components

### Buttons

**Primary Button:**
- Background: Safari Green with wood texture
- Border: 2px Gold
- Text: White, bold
- Padding: 12px vertical, 24px horizontal
- Border radius: 8px
- Shadow: 0 4px 8px rgba(0,0,0,0.3)

**Secondary Button:**
- Background: Earth Brown
- Border: 1px Dark Brown
- Text: Cream
- Same dimensions as primary

**Icon Button:**
- Circular or square
- Icon only, no text
- 48x48px minimum (for touch)
- Background: Semi-transparent

### Progress Bars

**Health Bar:**
- Height: 8px
- Background: Dark red
- Fill: Green to red gradient based on value
- Border: 1px dark brown
- Rounded ends

**Stamina Bar:**
- Height: 6px
- Background: Dark orange
- Fill: Yellow to orange gradient
- Animated pulse when low

**Mission Progress:**
- Height: 12px
- Background: Light tan
- Fill: Safari gold
- Percentage text overlay

### Cards

**Info Card:**
- Background: Cream with subtle texture
- Border: 2px Earth Brown
- Padding: 16px
- Shadow: 0 2px 4px rgba(0,0,0,0.2)
- Border radius: 12px

**Animal Card:**
- Image at top (16:9 ratio)
- Name below image
- Status indicator (discovered/locked)
- Tap animation: lift up slightly

### Icons

**Style:**
- Line art with fill
- 2px stroke width
- Consistent sizing (24x24, 32x32, 48x48)
- Color: Dark brown or white (depending on background)

**Common Icons:**
- 🏠 Home/Base
- 🎯 Mission/Objective
- 💧 Water
- 🔥 Fire
- 🏥 Medical
- 📍 Location
- ⚙️ Settings
- 📖 Encyclopedia
- 🎒 Inventory

## Animations

### Screen Transitions
- Fade: 0.3s
- Slide: 0.4s with ease-out
- Scale: 0.2s for buttons

### UI Feedback
- Button press: Scale down to 0.95, 0.1s
- Item pickup: Fly to inventory, 0.5s
- XP gain: Number count-up, 1s
- Health change: Flash, 0.2s

### Loading
- Spinner: Rotating compass
- Progress bar: Fill animation
- Skeleton screens for content loading

## Accessibility

### Text
- Minimum font size: 14px
- High contrast ratios (4.5:1 minimum)
- Scalable text option in settings

### Touch Targets
- Minimum size: 48x48px
- Adequate spacing: 8px between elements
- Clear visual feedback on touch

### Color Blindness
- Don't rely solely on color for information
- Use icons and patterns in addition to color
- Provide colorblind mode option

## Responsive Design

### Portrait Mode (Primary)
- Optimized for 16:9 and 18:9 aspect ratios
- Minimum resolution: 720x1280
- Maximum resolution: 1440x3040

### Landscape Mode (Optional)
- HUD elements move to sides
- Wider field of view
- Inventory grid expands

## Performance Considerations

- Use sprite atlases for UI elements
- Limit transparency layers
- Pool frequently used UI elements
- Lazy load encyclopedia images
- Compress UI textures (ASTC 6x6)

---

**Design Philosophy**: The UI should feel like a ranger's field equipment - practical, rugged, but with African cultural touches that celebrate the setting and wildlife.
